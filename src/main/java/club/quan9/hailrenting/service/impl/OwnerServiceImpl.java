package club.quan9.hailrenting.service.impl;

import club.quan9.hailrenting.domain.entity.Owner;
import club.quan9.hailrenting.repository.OwnerRepository;
import club.quan9.hailrenting.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService
{
    @Autowired
    OwnerRepository ownerRepository;

    @Override
    public Owner login(String id, String password)
    {
        Owner owner;
        owner=ownerRepository.findById(id);
        if(owner!=null && owner.getPassword().equals(password))
            return owner;
        else
            return null;
    }

    @Override
    public Owner getOwnerById(String id)
    {
        Owner owner;
        owner=ownerRepository.findById(id);
        return owner;
    }

    @Override
    public void save(Owner owner)
    {
        ownerRepository.save(owner);
    }

    @Override
    public String getId()
    {
        int i=Integer.valueOf(ownerRepository.getLastId());
        i++;
        return String.valueOf(i);
    }
}
