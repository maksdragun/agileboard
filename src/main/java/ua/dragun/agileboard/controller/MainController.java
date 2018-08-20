package ua.dragun.agileboard.controller;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@PropertySource(value = {"classpath:application.properties"})
public class MainController {

    @RequestMapping("/*")
    public String index(HttpSession session) {
        if (session.getAttribute("username") != null) {
            return "redirect:/tickets";
        } else {
            return "index";
        }
    }
}
