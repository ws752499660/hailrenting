package club.quan9.hailrenting.domain.entity;

public class Houseinfo
{
    private String addr;

    private String type;

    private int holdnum;

    private int price;

    private String ownerid;

    private String status;

    private String statusnote;

    private String id;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public void setAddr(String addr)
    {
        this.addr = addr;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setHoldnum(int holdnum)
    {
        this.holdnum = holdnum;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public void setOwnerid(String ownerid)
    {
        this.ownerid = ownerid;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setStatusnote(String statusnote)
    {
        this.statusnote = statusnote;
    }

    public String getAddr()
    {
        return addr;
    }

    public String getType()
    {
        return type;
    }

    public int getHoldnum()
    {
        return holdnum;
    }

    public int getPrice()
    {
        return price;
    }

    public String getOwnerid()
    {
        return ownerid;
    }

    public String getStatus()
    {
        return status;
    }

    public String getStatusnote()
    {
        return statusnote;
    }
}
