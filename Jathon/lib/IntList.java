package lib.Jathon;
import java.util.Arrays;
import static lib.Jathon.built_in.*;

public class IntList
{
    public final String version = "0.2.0.0 Alpha";
    int[] data;

    public IntList()
    {

    }
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
    public int[] output()
    {
        return this.data;
    }
}
