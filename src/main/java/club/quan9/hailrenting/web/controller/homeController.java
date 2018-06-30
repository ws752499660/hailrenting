package club.quan9.hailrenting.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController
{
    @RequestMapping({"/","index"})
    public String home()
    {
        return "home";
    }
}
