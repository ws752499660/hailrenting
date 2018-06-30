package club.quan9.hailrenting.domain.entity;

public class Owner
{
    private String name;

    private String addr;

    private String tel;

    private String id;

    private String password;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAddr(String addr)
    {
        this.addr = addr;
    }

    public void setTel(String tel)
    {
        this.tel = tel;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public String getAddr()
    {
        return addr;
    }

    public String getTel()
    {
        return tel;
    }

    public String getId()
    {
        return id;
    }

    public String getPassword()
    {
        return password;
    }
}
