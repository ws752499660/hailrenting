package club.quan9.hailrenting.service;

import club.quan9.hailrenting.domain.entity.Owner;

public interface OwnerService
{
    public Owner login(String id, String password);
    public Owner getOwnerById(String id);
    public void save(Owner owner);
    public String getId();
}
