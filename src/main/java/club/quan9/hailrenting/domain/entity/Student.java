package club.quan9.hailrenting.domain.entity;

public class Student
{
    private String name;

    private String addr;

    private String tel;

    private long birthday;

    private String gender;

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

    public void setBirthday(long birthday)
    {
        this.birthday = birthday;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
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

    public long getBirthday()
    {
        return birthday;
    }

    public String getGender()
    {
        return gender;
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
