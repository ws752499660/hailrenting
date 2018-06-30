package club.quan9.hailrenting.repository;

import club.quan9.hailrenting.domain.entity.Houseinfo;

import java.util.List;

public interface HouseInfoRepository
{
    public List<Houseinfo> findInfoByOwnerId(String id);
    public void saveInfo(Houseinfo houseinfo);
    public void updateInfo(Houseinfo houseinfo);
    public List<Houseinfo> getAll();
    public Houseinfo findByHouseId(String id);
}
