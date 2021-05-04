package Jathon.lib;

import java.util.*;

import static lib.Jathon.builtin.*;

/**
 * What is new?<br>
 * Add ArrayList<Integer> toArrayList() <br>
 * Add IntList(String) <br>
 * Change expression of some function
 */

public class IntList implements Iterable<Integer>
{
    public final String $version = "0.2.6.0";
    public int[] data;


    public IntList()
    {
        data = new int[0];
    }

    public IntList(int length)
    {
        data = new int[length];
        setAllTo(0);
    }

    public IntList(String arg)
    {
        this(arg, " ");
    }

    public IntList(String arg, String split)
    {
        this(inted(arg.split(split)));
    }

    /**
     * This constructor allows you to convert a String array to an IntList array.<br>
     * For example:
     *
     * @param arg
     */
    public IntList(String[] arg)
    {
        this();
        this.data = inted(arg);
    }

    public IntList(int... args)
    {
        this();
        this.data = new int[args.length];
        System.arraycopy(args, 0, this.data, 0, args.length);
    }

    public IntList(int[]... args)
    {
        this();
        int len = 0;
        for (int[] l : args)
        {
            len += l.length;
        }
        this.data = new int[len];
        int c = 0;
        for (int[] l : args)
        {
            for (int e : l)
            {
                this.data[c] = e;
                c += 1;
            }
        }
    }


    public Iterator<Integer> iterator()
    {
        return new Iterator<>()
        {
            int count = 0;

            public boolean hasNext()
            {
                return count < data.length;
            }

            public Integer next()
            {
                return data[count++];
            }
        };
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder("IntList");
        s.append(toStringPure());
        return s.toString();
    }

    public String toStringPure()
    {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i : data)
        {
            s.append(i + ",");
        }
        s.deleteCharAt(s.length() - 1);
        s.append("]");
        return s.toString();
    }

    public ArrayList<Integer> toArrayList()
    {
        ArrayList<Integer> r = new ArrayList<Integer>(this.data.length);
        for (int i = 0; i < this.data.length; i++)
        {
            r.add(i, this.data[i]);
        }
        return r;
    }


    public void setAllTo(int target)
    {
        Arrays.fill(this.data, target);
    }

    public void sort()
    {
        Arrays.sort(this.data);
    }

    public int[] toArray()
    {
        return this.data;
    }

    public void append(int x)
    {
        append(new int[]{x});
    }

    public void append(int[] obj)
    {
        int[] ret = new int[this.data.length + obj.length];
        System.arraycopy(this.data, 0, ret, 0, this.data.length);
        for (int i = this.data.length, j = 0; i < ret.length; i++, j++)
        {
            ret[i] = obj[j];
        }
        this.data = ret;
    }

    public void append(IntList obj)
    {
        append(obj.data);
    }

    public boolean has(int x)
    {
        for (int i : this.data)
        {
            if (i == x)
            {
                return true;
            }
        }
        return false;
    }

    public int popObj(int obj)
    {
        for (int i = 0; i < this.data.length; i++)
        {
            if (obj == this.data[i])
            {
                int[] ret = new int[this.data.length - 1];
                System.arraycopy(this.data, 0, ret, 0, i);
                if (ret.length - i >= 0)
                {
                    System.arraycopy(this.data, i + 1, ret, i, ret.length - i);
                }
                this.data = ret;
                return i;
            }
        }
        throw new NoSuchElementException("No such Element in this IntList");
    }

    public int popIndex(int index)
    {
        int ret = this.data[index];
        IntList newData = new IntList();
        newData.append(Arrays.copyOfRange(this.data, 0, index));
        newData.append(Arrays.copyOfRange(this.data, index + 1, this.data.length));
        this.data = newData.data;
        return ret;
    }

    public void reset()
    {
        this.data = new int[0];
    }
}