package club.quan9.hailrenting.repository.impl;

import club.quan9.hailrenting.domain.entity.MeetingInfo;
import club.quan9.hailrenting.repository.MeetingInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class MeetingInfoRepositoryImpl implements MeetingInfoRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    private String SQL_GETALL="SELECT time,addr,ownername,ownertel," +
            "studentname,studenttel,studentgender,finsh,houseid FROM meetinginfo";

    private String SQL_SAVE="insert INTO meetinginfo(time,addr,ownername,ownertel," +
            "studentname,studenttel,studentgender,finsh,houseid)VALUES (?,?,?,?,?,?,?,?,?)";

    private String SQL_CHANGEFIN="UPDATE meetinginfo SET finsh='Y' WHERE houseid=?";

    @Override
    public List<MeetingInfo> getAllInfo()
    {
        final List<MeetingInfo> list=new ArrayList<>();
        jdbcTemplate.query(SQL_GETALL, new RowCallbackHandler()
        {
            @Override
            public void processRow(ResultSet rs) throws SQLException
            {

                MeetingInfo meetingInfo=new MeetingInfo();
                meetingInfo.setTime(rs.getTimestamp("time"));
                meetingInfo.setAddr(rs.getString("addr"));
                meetingInfo.setOwnerName(rs.getString("ownername"));
                meetingInfo.setOwnerTel(rs.getString("ownertel"));
                meetingInfo.setStudentName(rs.getString("studentname"));
                meetingInfo.setStudentTel(rs.getString("studenttel"));
                meetingInfo.setStudentGender(rs.getString("studentgender"));
                meetingInfo.setFinsh(rs.getString("finsh"));
                meetingInfo.setHouseId(rs.getString("houseid"));
                list.add(meetingInfo);
            }
        });
        changeFinsh(list);
        return list;
    }

    @Override
    public void save(MeetingInfo meetingInfo)
    {
        jdbcTemplate.update(SQL_SAVE,meetingInfo.getTime(),meetingInfo.getAddr(),
                meetingInfo.getOwnerName(),meetingInfo.getOwnerTel(),
                meetingInfo.getStudentName(), meetingInfo.getStudentTel(),
                meetingInfo.getStudentGender(), meetingInfo.getFinsh(),meetingInfo.getHouseId());
    }

    private void changeFinsh(List<MeetingInfo> list)
    {
        Date date=new Date();
        int i=0;
        for(;i<list.size();i++)
        {
            if(list.get(i).getTime().getTime()<=date.getTime())
            {
                list.get(i).setFinsh("Y");
                jdbcTemplate.update(SQL_CHANGEFIN,list.get(i).getHouseId());
            }
        }
    }
}
