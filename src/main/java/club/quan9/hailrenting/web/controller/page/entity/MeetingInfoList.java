package club.quan9.hailrenting.web.controller.page.entity;

import club.quan9.hailrenting.domain.entity.MeetingInfo;

import java.util.List;

public class MeetingInfoList
{
    private List<MeetingInfo> list;

    public void setList(List<MeetingInfo> list)
    {
        this.list = list;
    }

    public List<MeetingInfo> getList()
    {
        return list;
    }
}
