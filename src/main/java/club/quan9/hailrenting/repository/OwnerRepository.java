package club.quan9.hailrenting.repository;

import club.quan9.hailrenting.domain.entity.Owner;

public interface OwnerRepository
{
    public Owner findById(String id);
    public void save(Owner owner);
    public String getLastId();
}
