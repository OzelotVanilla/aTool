package lib.Jathon;
import java.util.Arrays;
import java.util.Scanner;

public final class built_in
{
    public final String version = "0.2.0.0 Alpha";

    /**
     * This is the builtin file in Jathon. Do not try to initialize instance of this class.<br>
     * You can use this freely.
     */
    private built_in()
    {
    }

    public static void print(int[] x)
    {
        for (int i = 0; i < x.length; i++)
        {
            if (i != x.length - 1)
            {
                print(x[i] + ", ");
            }
            else
            {
                print(x[i]);
            }
        }
    }

    /**
     * An easy function for print data. Shorter than "System.out.println", easier to use (use comma
     * to seperate variables, do not worry about data type).
     * 
     * 
     * @param argument
     * @param end
     */
    public static void print(Object... args)
    {
        if (args.length == 0)
        {
            System.out.println();
        }
        else
        {
            for (Object x : args)
            {
                System.out.print(x);
            }
        }
    }
    public static void println(Object... args)
    {
        print(args);
        print();
    }
    public static void printf(String optionStr, Object objectStr)
    {
        System.out.printf(optionStr, objectStr);
    }
    public static void printa(Object[] x)
    {
        for (Object obj : x)
        {
            print(obj);
        }
    }
    public static void print(IntList x)
    {
        print(x.data);
    }
    public static int inted(String x)
    {
        return Integer.parseInt(x);
    }
    public static int inted(float x)
    {
        return (int) x;
    }
    public static int inted(double x)
    {
        return (int) x;
    }
    private static Scanner scanner_s = new Scanner(System.in);
    public static String input()
    {
        return scanner_s.nextLine();
    }
    public static String input(String x)
    {
        print(x);
        return input();
    }
    public static int inputOneInt()
    {
        return scanner_s.nextInt();
    }
    public static int inputOneInt(String x)
    {
        print(x);
        return inputOneInt();
    }
    public static int[] sorted(int[] x)
    {
        int[] t = Arrays.copyOf(x, x.length);
        Arrays.sort(t);
        return t;
    }
    public static int[] sorted(IntList x)
    {
        return sorted(x.output());
    }
}
