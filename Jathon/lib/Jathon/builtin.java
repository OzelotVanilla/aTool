package lib.Jathon;
import java.util.Arrays;
import java.util.Scanner;

/**
 * What is new?<br>
 * * OK version of randint().<br>
 * * Very first version of abs(), min() and max(), reversed().<br>
 * * Shorter name for Math.pow -> pow(), Python already has that.
 */

public final class builtin
{
    public final String version = "0.2.1.0";

    /**
     * This is the builtin file in Jathon. Do not try to initialize instance of this class.<br>
     * You can use this freely.
     */
    private builtin()
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
     * @param e
     * 
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
    public static void printf(String optionStr, Object... objectStr)
    {
        System.out.printf(optionStr, objectStr);
    }
    public static void printfl(String optionStr, Object... objectStr)
    {
        System.out.printf(optionStr, objectStr);
        print();
    }
    public static void printa(Object[] x)
    {
        for (Object obj : x)
        {
            print(obj + " ");
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
    public static int[] inted(String[] arg)
    {
        int[] ret = new int[arg.length];
        int i = 0;
        for (String x : arg)
        {
            ret[i] = inted(x);
        }
        return ret;
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
        return sorted(x.toArray());
    }

    // TODO: Reversed function

    public static int reversed(int x)
    {
        return inted(reversed(Integer.toString(x)));
    }
    public static String reversed(String s)
    {
        StringBuilder b = new StringBuilder();
        char[] c = s.toCharArray();
        for (int i = c.length - 1; i >= 0; i--)
        {
            b.append(c[i]);
        }
        return b.toString();
    }
    // public static <E> E reversed(E[] i)
    // {

    // }

    // Math function.

    // TODO: Wrong randint()
    /**
     * Use system time to return a random number.<br>
     *
     * @return int from 0 to 100 (edge included)
     */
    public static int randint()
    {
        return randint(0, 100);
    }
    /**
     * Use system time to return a random number.<br>
     *
     * @param s The start number of ramdom int
     * @param e The e number of ramdom int
     * @return int from 0 to 100 (edge included)
     */
    public static int randint(int s, int e)
    {
        return inted(System.nanoTime() % 1000000000) % (e - s) + s;
    }
    /**
     * 
     * @param x
     * @return The absolute data of the input number
     */
    public static int abs(int x)
    {
        return x > 0 ? x : -x;
    }
    /**
     * 
     * @param args The data you want to pick.
     * @return The max data from input
     */
    public static int max(int... args)
    {
        int r = args[0];
        for (int x : args)
        {
            r = (x > r ? x : r);
        }
        return r;
    }
    /**
     * 
     * @param args The data you want to pick.
     * @return The min data from input
     */
    public static int min(int... args)
    {
        int r = args[0];
        for (int x : args)
        {
            r = (x < r ? x : r);
        }
        return r;
    }
    public static double pow(double a, double b)
    {
        return Math.pow(a, b);
    }
}
