package org.cesno.jathon.exception;

public class ExceptionReason
{
    String reason;
    Object wrong;
    String need;
    String need_type;
    String need_range;


    public ExceptionReason(String reason)
    {
        this.reason = reason;
    }

    public ExceptionReason(String reason, long wrong)
    {
        this.reason = reason;
        this.wrong = wrong;
    }

    public ExceptionReason(String reason, double wrong)
    {
        this.reason = reason;
        this.wrong = wrong;
    }

    public ExceptionReason(String reason, char wrong)
    {
        this.reason = reason;
        this.wrong = wrong;
    }

    public ExceptionReason(String reason, boolean wrong)
    {
        this.reason = reason;
        this.wrong = wrong;
    }

    public ExceptionReason(String reason, Object wrong)
    {
        this.reason = reason;
        this.wrong = wrong;
    }

    public void setNeed(String type)
    {
        setNeed(type, "");
    }

    public void setNeed(String type, String range)
    {
        this.need_type = type;
        this.need_range = range;
    }
}