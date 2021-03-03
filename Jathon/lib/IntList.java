package lib.Jathon;
import java.util.Arrays;
import static lib.Jathon.builtin.*;

/**
 * What is new?<br>
 * * name changed output() -> toArray()
 */

public class IntList
{
    public final String version = "0.2.1.0";
    int[] data;

    public IntList()
    {

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
    public IntList(String[] arg, int mode)
    {
        this();
        if (mode == 1)
        {
            arg = Arrays.copyOfRange(arg, 1, arg.length);
        }
        this.data = new int[arg.length];
        for (int i = 0; i < this.data.length; i++)
        {
            this.data[i] = inted(arg[i]);
        }
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
    public void sort()
    {
        Arrays.sort(this.data);
    }
    public int[] toArray()
    {
        return this.data;
    }

}
