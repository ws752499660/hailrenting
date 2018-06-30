package club.quan9.hailrenting.web.controller.page.entity;

import java.util.List;

public class DateList
{
    private int[] month;
    private int[] hour;

    public DateList()
    {
        int i=0;
        for(;i<12;i++)
            month[i]=i+1;
        for(i=0;i<60;i++)
            hour[i]=i+1;
    }

    public void setMonth(int[] month)
    {
        this.month = month;
    }

    public void setHour(int[] hour)
    {
        this.hour = hour;
    }

    public int[] getMonth()
    {
        return month;
    }

    public int[] getHour()
    {
        return hour;
    }
}
