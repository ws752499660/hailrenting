package club.quan9.hailrenting.web.controller.page.entity;

import club.quan9.hailrenting.domain.entity.Houseinfo;

import java.util.List;

public class HouseinfoList
{
    private List<Houseinfo> list;

    public void setList(List<Houseinfo> list)
    {
        this.list = list;
    }

    public List<Houseinfo> getList()
    {
        return list;
    }
}
