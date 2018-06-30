package club.quan9.hailrenting.service;

import club.quan9.hailrenting.domain.entity.Houseinfo;
import club.quan9.hailrenting.web.controller.page.entity.HouseinfoList;

import java.util.List;

public interface HouseInfoService
{
    public List<Houseinfo> getInfosByOwnerId(String id);
    public void saveInfo(Houseinfo houseinfo);
    public void updateInfo(HouseinfoList houseinfoList);
    public List<Houseinfo> getAll();
    public Houseinfo getInfoById(String id);
    public List<Houseinfo> checkBookingList(List<Houseinfo> list);
}
