package club.quan9.hailrenting.domain.entity;

import java.util.Date;

public class MeetingInfo
{
    private Date time;
    private String addr;
    private String ownerName;
    private String studentName;
    private String finsh;
    private String houseId;
    private String ownerTel;
    private String studentTel;
    private String studentGender;

    public Date getTime()
    {
        return time;
    }

    public void setTime(Date time)
    {
        this.time = time;
    }

    public String getAddr()
    {
        return addr;
    }

    public void setAddr(String addr)
    {
        this.addr = addr;
    }

    public String getOwnerName()
    {
        return ownerName;
    }

    public void setOwnerName(String ownerName)
    {
        this.ownerName = ownerName;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String getFinsh()
    {
        return finsh;
    }

    public void setFinsh(String finsh)
    {
        this.finsh = finsh;
    }

    public String getHouseId()
    {
        return houseId;
    }

    public void setHouseId(String houseId)
    {
        this.houseId = houseId;
    }

    public String getOwnerTel()
    {
        return ownerTel;
    }

    public void setOwnerTel(String ownerTel)
    {
        this.ownerTel = ownerTel;
    }

    public String getStudentTel()
    {
        return studentTel;
    }

    public void setStudentTel(String studentTel)
    {
        this.studentTel = studentTel;
    }

    public String getStudentGender()
    {
        return studentGender;
    }

    public void setStudentGender(String studentGender)
    {
        this.studentGender = studentGender;
    }
}

