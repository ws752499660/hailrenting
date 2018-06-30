package club.quan9.hailrenting.service.impl;


import club.quan9.hailrenting.domain.entity.Houseinfo;
import club.quan9.hailrenting.web.controller.page.entity.HouseinfoList;
import club.quan9.hailrenting.repository.HouseInfoRepository;
import club.quan9.hailrenting.service.HouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseInfoServiceImpl implements HouseInfoService
{
    @Autowired
    private HouseInfoRepository houseInfoRepository;

    @Override
    public List<Houseinfo> getInfosByOwnerId(String id)
    {
        List<Houseinfo> list=houseInfoRepository.findInfoByOwnerId(id);

        return list;
    }

    @Override
    public void saveInfo(Houseinfo houseinfo)
    {
        houseInfoRepository.saveInfo(houseinfo);
    }

    @Override
    public void updateInfo(HouseinfoList houseinfoList)
    {
        for(int i=0;i<houseinfoList.getList().size();i++)
        {
            Houseinfo houseinfo=houseinfoList.getList().get(i);
//            houseinfo.setId(houseinfo.getHoldnum()+"-"+houseinfo.getPrice()+"-"+
//                    houseinfo.getOwnerid()+"-"+houseinfo.getAddr());
            houseInfoRepository.updateInfo(houseinfo);
        }
    }

    @Override
    public List<Houseinfo> getAll()
    {
        return houseInfoRepository.getAll();
    }

    @Override
    public Houseinfo getInfoById(String id)
    {
        return houseInfoRepository.findByHouseId(id);
    }

    @Override
    public List<Houseinfo> checkBookingList(List<Houseinfo> list)
    {
        List<Houseinfo> checkedList=new ArrayList<>();
        int i=0;
        for(;i<list.size();i++)
        {
            if(list.get(i).getStatus().equals("不可出租"))
                continue;
            else
                checkedList.add(list.get(i));
        }
        return checkedList;
    }
}
