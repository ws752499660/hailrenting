package club.quan9.hailrenting.service;

import club.quan9.hailrenting.domain.entity.Houseinfo;
import club.quan9.hailrenting.domain.entity.MeetingInfo;
import club.quan9.hailrenting.domain.entity.Owner;
import club.quan9.hailrenting.domain.entity.Student;

import java.util.List;

public interface MeetingInfoService
{
    public List<MeetingInfo> getAllInfo();
    public MeetingInfo createMeeting(MeetingInfo meetingInfo,Houseinfo houseinfo,
                                     Owner owner, Student student);
    public List<MeetingInfo> stuCheckList(List<MeetingInfo> list,Student student);
    public List<MeetingInfo> ownerCheckList(List<MeetingInfo> list,Owner owner);
    public void save(MeetingInfo meetingInfo);
}