package Jathon.lib;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * What is new?<br>
 * Completing function len() <br>
 * New function booled() <br>
 * randint() fixed, using Java's function
 */

public final class builtin
{
    public final String $version = "0.2.6.0";

    public static final String CR = System.getProperty("line.separator");

    /**
     * This is the builtin file in Jathon. Do not try to initialize instance of this class.<br>
     * You can use this freely.
     */
    private builtin()
    {
    }


    /**
     * An easy function for print data. Shorter than "System.out.println", easier to use (use comma to separate
     * variables, do not worry about data type).
     */
    public static void printx(Object... args)
    {
        if (args.length == 0)
        {
            System.out.println();
        }
        else if (args.length == 1 && !args[0].getClass().isArray())
        {
            System.out.print(args[0]);
        }
        else
        {
            StringBuilder r = new StringBuilder(Arrays.deepToString(args));
            // Delete the brackets of Arrays.deepToString() and print
            System.out.print(r.deleteCharAt(r.length() - 1).deleteCharAt(0));
        }
    }

    public static void print()
    {
        System.out.println();
    }

    public static void print(Object... args)
    {
        printx(args);
        print();
    }

    public static void print(IntList arg)
    {
        printx(arg);
        printx();
    }

    public static void printxf(String option_str, Object... object_str)
    {
        System.out.printf(option_str, object_str);
    }

    public static void printf(String option_str, Object... object_str)
    {
        System.out.printf(option_str + "\n", object_str);
    }


    public static int len(String s)
    {
        return s.length();
    }

    public static int len(int i)
    {
        return inted(StrictMath.log10(i));
    }

    public static <U> int len(U[] a)
    {
        return a.length;
    }


    public static void cls()
    {
        // Idea from https://stackoverflow.com/questions/2979383/java-clear-the-console
        try
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch (Exception e)
        {
            print("Failed to clean the screen.");
        }
    }


    public static String deciFmt(double d)
    {
        return deciFmt(d, 4);
    }

    public static String deciFmt(double d, int scale)
    {
        BigDecimal x = new BigDecimal(d);
        x = x.setScale(scale, RoundingMode.HALF_DOWN);
        return x.toString();
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
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = inted(arg[i]);
        }
        return ret;
    }

    public static double[] doubled(String[] arg)
    {
        double[] ret = new double[arg.length];
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = doubled(arg[i]);
        }
        return ret;
    }

    public static double doubled(String x)
    {
        return Double.parseDouble(x);
    }

    public static boolean booled(int x)
    {
        return x != 0;
    }

    public static boolean booled(double x)
    {
        return x != 0.0;
    }

    public static String str(long x)
    {
        return Long.toString(x);
    }


    private static final Scanner scanner_s = new Scanner(System.in);

    public static String input()
    {
        return scanner_s.nextLine();
    }

    public static String input(String x)
    {
        printx(x);
        return input();
    }

    public static int inputOneInt()
    {
        return scanner_s.nextInt();
    }

    public static int inputOneInt(String x)
    {
        printx(x);
        return inputOneInt();
    }

    public static double inputOneDouble()
    {
        return scanner_s.nextDouble();
    }

    public static double inputOneDouble(String x)
    {
        printx(x);
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

    @SuppressWarnings("unchecked")
    public static <E> E reversed(E[] arr)
    {
        int i = arr.length;
        Object[] ret = new Object[i];
        for (E x : arr)
        {
            ret[i--] = x;
        }
        return (E) ret;
    }


    // Math function.

    static Random random = new Random();

    /**
     * Use system time to return a random number.<br>
     *
     * @return int from 0 to 100 (both edges are included)
     */
    public static int randint()
    {
        return randint(0, 100);
    }

    /**
     * Use system time to return a random number.<br>
     *
     * @param s The start number of random int
     * @param e The e number of random int
     * @return int from <i>s</i> to <i>e</i> (both edges are included)
     */
    public static int randint(int s, int e)
    {
        return random.nextInt(e - s + 1) + s;
    }


    public static int abs(int x)
    {
        return x >= 0 ? x : -x;
    }

    /**
     * @param x The value you want to get absolute value
     * @return The absolute data of the input number
     */
    public static <numeric extends Number> double abs(numeric x)
    {
        return x.doubleValue() >= 0 ? x.doubleValue() : -x.doubleValue();
    }

    /**
     * @param args The data you want to pick.
     * @return The max data from input
     */
    @SafeVarargs
    public static <cmpable extends Number> cmpable max(cmpable... args)
    {
        cmpable r = args[0];
        for (cmpable x : args)
        {
            r = (x.doubleValue() > r.doubleValue() ? x : r);
        }
        return r;
    }

    @SafeVarargs
    public static <cmpable extends Number> cmpable max(cmpable[]... args)
    {
        cmpable r = args[0][0];
        for (cmpable[] c : args)
        {
            r = max(c);
        }
        return r;
    }

    /**
     * @param args The data you want to pick.
     * @return The min data from input
     */
    @SafeVarargs
    public static <cmpable extends Number> cmpable min(cmpable... args)
    {
        cmpable r = args[0];
        for (cmpable x : args)
        {
            r = (x.doubleValue() < r.doubleValue() ? x : r);
        }
        return r;
    }

    @SafeVarargs
    public static <cmpable extends Number> cmpable min(cmpable[]... args)
    {
        cmpable r = args[0][0];
        for (cmpable[] c : args)
        {
            r = min(c);
        }
        return r;
    }

    public static double pow(double a, double b)
    {
        return StrictMath.pow(a, b);
    }

    public static double sqrt(double a)
    {
        return StrictMath.sqrt(a);
    }

    public static double ln(double x)
    {
        return Math.log(x);
    }

    public static String hex(int x)
    {
        return "0x" + Integer.toHexString(x);
    }

    public static String bin(int x)
    {
        return "0b" + Integer.toBinaryString(x);
    }

    public static String oct(int x)
    {
        return "0o" + Integer.toOctalString(x);
    }
}