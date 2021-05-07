package org.cesno.jathon.time;

import static org.cesno.jathon.builtin.*;

import org.cesno.jathon.exception.ExceptionReason;

import java.time.ZoneOffset;


public class Timezone
{
    /**
     * <p>
     * Save the offset of time in precision of minutes.
     * </p>
     *
     * <p>
     * Example: Paris is {@code UTC +02:00}, its {@code offset} is {@code +200}.
     * </p>
     */
    private int offset;

    public static void main(String[] args)
    {
        Timezone x = new Timezone(2343212);
    }

    /**
     *
     */
    public Timezone()
    {
        this.offset = 0;
    }

    public Timezone(ZoneOffset offset)
    {
        // TODO Auto-generated method stub
    }

    public Timezone(double offset)
    {
        setTimeZone(offset);
    }


    public void setTimeZone(double offset)
    {
        if (offset >= -12 && offset <= 12)
        {
            this.offset = inted(offset * 100);
        }
        else if (offset >= -1200 && offset <= 1200)
        {
            this.offset = inted(offset);
        }
        else
        {
            print("You need to init Timezone properly.");
            print("\tWhat you have input is: " + offset);
            print("\tExample for legal args:");
            print("\t\tTimezone(1000)\t create timezone UTC +10:00\n");
            throw new IllegalArgumentException("Arg out of range");
        }
    }
}