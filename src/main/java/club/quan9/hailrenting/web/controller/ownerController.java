package club.quan9.hailrenting.web.controller;

import club.quan9.hailrenting.domain.entity.Houseinfo;
import club.quan9.hailrenting.service.MeetingInfoService;
import club.quan9.hailrenting.web.controller.page.entity.HouseinfoList;
import club.quan9.hailrenting.web.controller.page.entity.Logininfo;
import club.quan9.hailrenting.domain.entity.Owner;
import club.quan9.hailrenting.service.HouseInfoService;
import club.quan9.hailrenting.service.OwnerService;
import club.quan9.hailrenting.web.controller.page.entity.MeetingInfoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("owner")
public class ownerController
{
    @Autowired
    OwnerService ownerService;
    @Autowired
    HouseInfoService houseInfoService;
    @Autowired
    MeetingInfoService meetingInfoService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showLogin(Model model)
    {
        model.addAttribute("logininfo",new Logininfo());
        return "owner_login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String processLogin(@Valid Logininfo user, Error error, RedirectAttributes model,HttpSession session)
    {
        Owner owner;
        owner= ownerService.login(user.getId(),user.getPassword());
        if(owner!=null)
        {
            session.setAttribute("owner",owner);
            return "redirect:"+owner.getId();
        }
        else
            return "owner_login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String ownerRegister(Model model)
    {
        Owner owner=new Owner();
        model.addAttribute("owner",owner);
        return "owner_register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String ownerRegisterProcess(@Valid Owner owner,Model model)
    {
        owner.setId(ownerService.getId());
        ownerService.save(owner);
        model.addAttribute("owner",owner);
        return "owner_showre";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String ownerProfile(@SessionAttribute("owner")Owner owner,@PathVariable String id,
                               Model model,HttpSession session)
    {
        HouseinfoList infoList=new HouseinfoList();
        MeetingInfoList meetingInfoList=new MeetingInfoList();

        infoList.setList(houseInfoService.getInfosByOwnerId(id));

        meetingInfoList.setList(meetingInfoService.getAllInfo());
        meetingInfoList.setList(meetingInfoService.ownerCheckList(meetingInfoList.getList(),owner));

        model.addAttribute("meetingInfoList",meetingInfoList);
        model.addAttribute("owner",owner);
        model.addAttribute("infoList",infoList);
        session.setAttribute("infoList",infoList);
        session.setAttribute("meetingInfoList",meetingInfoList);
        return "owner_profile";
    }

    @RequestMapping(value = "/{id}/addinfo",method = RequestMethod.GET)
    public String showAddInfo(@PathVariable int id, Model model)
    {
        String pageId=String.valueOf(id);
        model.addAttribute("id",pageId);
        model.addAttribute("newInfo",new Houseinfo());
        return "owner_addinfo";
    }

    @RequestMapping(value = "/{id}/addinfo",method = RequestMethod.POST)
    public String addInfoPay(@Valid Houseinfo houseinfo,
                             @SessionAttribute("owner") Owner owner,
                             Model model,HttpSession session)
    {
        model.addAttribute(houseinfo);
        model.addAttribute(owner);
        session.setAttribute("houseinfo",houseinfo);
        return "owner_addpay";
    }

    @RequestMapping(value = "/{id}/afterpay",method = RequestMethod.GET)
    public String processAddInfo(@SessionAttribute("owner") Owner owner,
                                 @SessionAttribute("meetingInfoList")MeetingInfoList meetingInfoList,
                                 @PathVariable String id,
                                 @SessionAttribute("houseinfo") Houseinfo houseinfo,
                                 Error error,Model model)
    {
        houseinfo.setOwnerid(id);
        houseInfoService.saveInfo(houseinfo);
        //这里是更新操作，不能从session中找原来的就塞进去
        HouseinfoList infoList=new HouseinfoList();
        infoList.setList(houseInfoService.getInfosByOwnerId(id));
        model.addAttribute(owner);
        model.addAttribute("infoList",infoList);
        model.addAttribute("meetingInfoList",meetingInfoList);
        return "owner_profile";
    }

    @RequestMapping(value = "/{id}/editinfo",method = RequestMethod.GET)
    public String showEditInfo(@SessionAttribute("infoList") HouseinfoList infoList,
                               @SessionAttribute("owner") Owner owner,
                               Model model)
    {
        model.addAttribute("owner",owner);
        model.addAttribute("infoList",infoList);
        return "owner_editinfo";
    }

    @RequestMapping(value ="/{id}/editinfo",method = RequestMethod.POST)
    public String processEditInfo(@Valid HouseinfoList houseinfoList,
                                  @SessionAttribute("owner") Owner owner,
                                  @SessionAttribute("meetingInfoList")MeetingInfoList meetingInfoList,
                                  @PathVariable String id,
                                  Model model)
    {
        houseInfoService.updateInfo(houseinfoList);
        HouseinfoList infoList=new HouseinfoList();
        infoList.setList(houseInfoService.getInfosByOwnerId(id));
        model.addAttribute("infoList",infoList);
        model.addAttribute("meetingInfoList",meetingInfoList);
        model.addAttribute(owner);
        return "owner_profile";
    }
}