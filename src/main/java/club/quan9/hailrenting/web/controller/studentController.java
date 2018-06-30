package club.quan9.hailrenting.web.controller;

import club.quan9.hailrenting.domain.entity.*;
import club.quan9.hailrenting.service.HouseInfoService;
import club.quan9.hailrenting.service.MeetingInfoService;
import club.quan9.hailrenting.service.OwnerService;
import club.quan9.hailrenting.service.StudentService;
import club.quan9.hailrenting.web.controller.page.entity.HouseinfoList;
import club.quan9.hailrenting.web.controller.page.entity.Logininfo;
import club.quan9.hailrenting.web.controller.page.entity.MeetingInfoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("student")
public class studentController
{
    @Autowired
    private StudentService studentService;

    @Autowired
    private HouseInfoService houseInfoService;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private MeetingInfoService meetingInfoService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model)
    {
        model.addAttribute(new Logininfo());
        return "stu_login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processLogin(@Valid Logininfo logininfo, Model model, HttpSession session)
    {
        Student student = studentService.login(logininfo.getId(), logininfo.getPassword());
        if (student!=null)
        {
            session.setAttribute("student", student);
            return "redirect:"+student.getId();
        }
        else
            return "stu_login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String studentRegister(Model model)
    {
        Student student=new Student();
        model.addAttribute("student",student);
        return "stu_register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String studentRegisterProcess(@Valid Student student,Model model)
    {
        student.setId(studentService.setId(student));
        studentService.save(student);
        return "stu_showre";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String studentProfile(@SessionAttribute("student") Student student,
                                 HttpSession session,
                                 Model model)
    {
        Houseinfo houseinfo=new Houseinfo();
        HouseinfoList infoList=new HouseinfoList();
        MeetingInfoList meetingInfoList=new MeetingInfoList();
        infoList.setList(houseInfoService.getAll());
        meetingInfoList.setList(meetingInfoService.getAllInfo());
        meetingInfoList.setList(meetingInfoService.stuCheckList(meetingInfoList.getList(),student));
        model.addAttribute("infoList",infoList);
        model.addAttribute(student);
        model.addAttribute("meetingInfoList",meetingInfoList);
        session.setAttribute("infoList",infoList);
        return "stu_profile";
    }

    @RequestMapping(value = "/{id}/booking" ,method = RequestMethod.GET)
    public String booking(@SessionAttribute("infoList")HouseinfoList infoList,
                          @SessionAttribute("student")Student student,
                          Model model)
    {
        Houseinfo houseinfo=new Houseinfo();
        MeetingInfo meetingInfo=new MeetingInfo();
//        DateList dateList=new DateList();
        infoList.setList(houseInfoService.checkBookingList(infoList.getList()));
        model.addAttribute("infoList",infoList);
        model.addAttribute(houseinfo);
        model.addAttribute("meetingInfo",meetingInfo);
        model.addAttribute("student",student);
//        model.addAttribute(dateList);
        return "stu_booking";
    }

    @RequestMapping(value = "/{id}/booking",method = RequestMethod.POST)
    public String bookingProcess(MeetingInfo meetingInfo,
                                 @SessionAttribute("student") Student student,
                                 @SessionAttribute("infoList")HouseinfoList infoList,
                                 @PathVariable("id")String id,
                                 Model model)
    {
        Houseinfo houseinfo=houseInfoService.getInfoById(meetingInfo.getHouseId());
        Owner owner=ownerService.getOwnerById(houseinfo.getOwnerid());
        MeetingInfoList meetingInfoList=new MeetingInfoList();

        meetingInfo=meetingInfoService.createMeeting(meetingInfo,houseinfo,owner,student);
        meetingInfoService.save(meetingInfo);

        meetingInfoList.setList(meetingInfoService.getAllInfo());
        meetingInfoList.setList(meetingInfoService.stuCheckList(meetingInfoList.getList(),student));

        model.addAttribute("student",student);
        model.addAttribute("infoList",infoList);
        model.addAttribute("meetingInfoList",meetingInfoList);
        return "stu_profile";
    }
}
