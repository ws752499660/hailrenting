package club.quan9.hailrenting.service.impl;

import club.quan9.hailrenting.domain.entity.Houseinfo;
import club.quan9.hailrenting.domain.entity.MeetingInfo;
import club.quan9.hailrenting.domain.entity.Owner;
import club.quan9.hailrenting.domain.entity.Student;
import club.quan9.hailrenting.repository.MeetingInfoRepository;
import club.quan9.hailrenting.service.MeetingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class MeetingInfoServiceImpl implements MeetingInfoService
{
    @Autowired
    private MeetingInfoRepository meetingInfoRepository;

    @Override
    public List<MeetingInfo> getAllInfo()
    {
        return meetingInfoRepository.getAllInfo();
    }

    @Override
    public MeetingInfo createMeeting(MeetingInfo meetingInfo,Houseinfo houseinfo,
                                     Owner owner, Student student)
    {
        meetingInfo.setHouseId(houseinfo.getId());
        meetingInfo.setOwnerName(owner.getName());
        meetingInfo.setOwnerTel(owner.getTel());
        meetingInfo.setStudentName(student.getName());
        meetingInfo.setStudentTel(student.getTel());
        meetingInfo.setStudentGender(student.getGender());
        meetingInfo.setFinsh("N");
        meetingInfo.setTime(getMeetingTime());
        meetingInfo.setAddr(houseinfo.getAddr());
        return meetingInfo;
    }

    @Override
    public List<MeetingInfo> stuCheckList(List<MeetingInfo> list,Student student)
    {
        List<MeetingInfo> checkedList = new ArrayList<>();
        if(list==null)
            return null;
        int i = 0;
        for (; i<list.size(); i++)
        {
            if(list.get(i).getStudentName().equals(student.getName()))
                checkedList.add(list.get(i));
        }
        return checkedList;
    }

    @Override
    public List<MeetingInfo> ownerCheckList(List<MeetingInfo> list, Owner owner)
    {
        List<MeetingInfo> checkedList = new ArrayList<>();
        if(list==null)
            return null;
        for (int i = 0; i<list.size(); i++)
        {
            if(list.get(i).getOwnerName().equals(owner.getName()))
                checkedList.add(list.get(i));
        }
        return checkedList;
    }

    @Override
    public void save(MeetingInfo meetingInfo)
    {
        meetingInfoRepository.save(meetingInfo);
    }

    private Date getMeetingTime()
    {
        Date date=new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,1);
        date=calendar.getTime();
        return date;
    }
}
