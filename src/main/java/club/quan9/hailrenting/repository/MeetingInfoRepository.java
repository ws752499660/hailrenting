package club.quan9.hailrenting.repository;

import club.quan9.hailrenting.domain.entity.MeetingInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MeetingInfoRepository
{
    public List<MeetingInfo> getAllInfo();
    public void save(MeetingInfo meetingInfo);
}
