package Jathon.lib;
import java.util.*;
import static Jathon.lib.builtin.*;

/**
 * What is new?<br>
 * * Iterable IntList <br>
 * * Delete confusing constructor IntList(String, String) <br>
 * 
 * What we plan?<br>
 * * Write more about doc
 */

public class IntList implements Iterable<Integer>
{
    public final String $version = "0.2.4.0";
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
    public IntList(String arg, String split)
    {
        this(inted(arg.split(split)));
    }
    /**
     * This constructer allows you to convert a String array to an IntList array.<br>
     * For example:
     * 
     * @param arg
     * @param mode
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
        for (int i = 0; i < args.length; i++)
        {
            this.data[i] = args[i];
        }
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
        return new Iterator<Integer>()
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

    public void setAllTo(int target)
    {
        for (int i = 0; i < this.data.length; i++)
        {
            this.data[i] = target;
        }
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
        for (int i = 0; i < this.data.length; i++)
        {
            ret[i] = this.data[i];
        }
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
                for (int j = 0; j < i; j++)
                {
                    ret[j] = this.data[j];
                }
                for (int j = i; j < ret.length; j++)
                {
                    ret[j] = this.data[j + 1];
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

    public static void main(String[] args)
    {
        String x = "1 2 3";
        IntList y = new IntList(x.split(" "));
        printx(y);
    }
}
