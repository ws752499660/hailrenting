package club.quan9.hailrenting.repository.impl;

import club.quan9.hailrenting.domain.entity.Owner;
import club.quan9.hailrenting.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OwnerRepositoryImpl implements OwnerRepository
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String SQL_FIND="select name,addr,tel,id,password from owner where id=?";

    private String SQL_SAVE="INSERT INTO owner(name, addr, tel, id, password) " +
            "VALUES (?,?,?,?,?)";

    private String SQL_GETLASTID="select id from owner order by id desc limit 1";

    @Override
    public Owner findById(String id)
    {
        final List<Owner> list=new ArrayList<Owner>();
        boolean flag=false;
        jdbcTemplate.query(SQL_FIND,new Object[]{id},new RowCallbackHandler()
        {
            @Override
            public void processRow(ResultSet rs) throws SQLException
            {
                Owner owner=new Owner();
                owner.setName(rs.getString("name"));
                owner.setAddr(rs.getString("addr"));
                owner.setTel(rs.getString("tel"));
                owner.setId(rs.getString("id"));
                owner.setPassword(rs.getString("password"));
                list.add(owner);
            }
        });
        if(list.size()>0)
            return list.get(0);
        else
            return null;
    }

    @Override
    public void save(Owner owner)
    {
        jdbcTemplate.update(SQL_SAVE,owner.getName(),owner.getAddr(),owner.getTel(),
                owner.getId(),owner.getPassword());
    }

    @Override
    public String getLastId()
    {
        final List<String> list=new ArrayList<>();
        jdbcTemplate.query(SQL_GETLASTID, new RowCallbackHandler()
        {
            @Override
            public void processRow(ResultSet rs) throws SQLException
            {
                list.add(rs.getString("id"));
            }
        });
        return list.get(0);
    }
}
