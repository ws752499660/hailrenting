package club.quan9.hailrenting.repository.impl;

import club.quan9.hailrenting.domain.entity.Houseinfo;
import club.quan9.hailrenting.repository.HouseInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HouseInfoRepositoryImpl implements HouseInfoRepository
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String SQL_FINDINFO_BY_OWNERID="select addr,type,holdnum,price,ownerid,status," +
            "statusnote,id from houseinfo where ownerid=?";

    private String SQL_SAVEINFO="insert into houseinfo (addr,type,holdnum,price,ownerid," +
            "status,statusnote,id) values(?,?,?,?,?,?,?,?)";

    private String SQL_UPDATE="update houseinfo set addr=?,type=?,holdnum=?,price=?,ownerid=?," +
        "status=?,statusnote=? where id=?";

    private String SQL_GETALL="select addr,type,holdnum,price,ownerid,status," +
            "statusnote,id,ownerid FROM houseinfo";

    private String SQL_FINDBYID="select addr,type,holdnum,price,ownerid,status," +
            "statusnote,id,ownerid FROM houseinfo WHERE id=?";

    @Override
    public List<Houseinfo> findInfoByOwnerId(String id)
    {
        List<Houseinfo> list=new ArrayList<Houseinfo>();
        list=jdbcTemplate.query(SQL_FINDINFO_BY_OWNERID, new RowMapper<Houseinfo>()
        {
            @Nullable
            @Override
            public Houseinfo mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                Houseinfo houseinfo=new Houseinfo();
                houseinfo.setAddr(rs.getString("addr"));
                houseinfo.setType(rs.getString("type"));
                houseinfo.setHoldnum(rs.getInt("holdnum"));
                houseinfo.setPrice(rs.getInt("price"));
                houseinfo.setOwnerid(rs.getString("ownerid"));
                houseinfo.setStatus(rs.getString("status"));
                houseinfo.setStatusnote(rs.getString("statusnote"));
                houseinfo.setId(rs.getString("id"));
                return houseinfo;
            }
        },id);

        return list;
    }

    @Override
    public void saveInfo(Houseinfo houseinfo)
    {
        jdbcTemplate.update(SQL_SAVEINFO,houseinfo.getAddr(),houseinfo.getType(),
                houseinfo.getHoldnum(),houseinfo.getPrice(),houseinfo.getOwnerid(),
                houseinfo.getStatus(),houseinfo.getStatusnote(),
                houseinfo.getHoldnum()+"-"+houseinfo.getPrice()+"-"+houseinfo.getOwnerid()+"-"+houseinfo.getAddr());
    }

    @Override
    public void updateInfo(Houseinfo houseinfo)
    {
//        jdbcTemplate.update(SQL_UPDATE,houseinfo.getAddr(),houseinfo.getType(),
//                houseinfo.getHoldnum(),houseinfo.getPrice(),houseinfo.getOwnerid(),
//                houseinfo.getStatus(),houseinfo.getStatusnote(),houseinfo.getId());
        /*jdbcTemplate.update("update houseinfo set " +
                "addr="+"'"+houseinfo.getAddr()+"'"+
                ",type="+"'"+houseinfo.getType()+"'"+
                ",holdnum="+houseinfo.getHoldnum()+
                ",price=" +houseinfo.getPrice()+
                ",ownerid=" +"'"+houseinfo.getOwnerid()+"'"+
                ",status=" +"'"+houseinfo.getStatus()+"'"+
                ",statusnote=" +"'"+houseinfo.getStatusnote()+"'"+
                "where id="+"'"+houseinfo.getId()+"'");*/
        jdbcTemplate.update(SQL_UPDATE,houseinfo.getAddr(),houseinfo.getType(),houseinfo.getHoldnum(),
                houseinfo.getPrice(),houseinfo.getOwnerid(),houseinfo.getStatus(),houseinfo.getStatusnote(),
                houseinfo.getId());

    }

    @Override
    public List<Houseinfo> getAll()
    {
        final List<Houseinfo> list=new ArrayList<Houseinfo>();
        jdbcTemplate.query(SQL_GETALL, new RowCallbackHandler()
        {
            @Override
            public void processRow(ResultSet rs) throws SQLException
            {
                Houseinfo houseinfo=new Houseinfo();
                houseinfo.setAddr(rs.getString("addr"));
                houseinfo.setType(rs.getString("type"));
                houseinfo.setHoldnum(rs.getInt("holdnum"));
                houseinfo.setPrice(rs.getInt("price"));
                houseinfo.setOwnerid(rs.getString("ownerid"));
                houseinfo.setStatus(rs.getString("status"));
                houseinfo.setStatusnote(rs.getString("statusnote"));
                houseinfo.setId(rs.getString("id"));
                houseinfo.setOwnerid(rs.getString("ownerid"));
                list.add(houseinfo);
            }
        });
        return list;
    }

    @Override
    public Houseinfo findByHouseId(String id)
    {
        List<Houseinfo> list=new ArrayList<>();
        jdbcTemplate.query(SQL_FINDBYID, new Object[]{id}, new RowCallbackHandler()
        {
            @Override
            public void processRow(ResultSet rs) throws SQLException
            {
                Houseinfo houseinfo=new Houseinfo();
                houseinfo.setAddr(rs.getString("addr"));
                houseinfo.setType(rs.getString("type"));
                houseinfo.setHoldnum(rs.getInt("holdnum"));
                houseinfo.setPrice(rs.getInt("price"));
                houseinfo.setOwnerid(rs.getString("ownerid"));
                houseinfo.setStatus(rs.getString("status"));
                houseinfo.setStatusnote(rs.getString("statusnote"));
                houseinfo.setOwnerid(rs.getString("ownerid"));
                houseinfo.setId(rs.getString("id"));
                list.add(houseinfo);
            }
        });
        if(list.size()>0)
            return list.get(0);
        else
            return null;
    }
}
