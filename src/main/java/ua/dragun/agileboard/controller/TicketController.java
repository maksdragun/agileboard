package ua.dragun.agileboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.dragun.agileboard.entity.ticket.Ticket;
import ua.dragun.agileboard.entity.user.User;
import ua.dragun.agileboard.service.enums.LoginStatus;
import ua.dragun.agileboard.service.loginservice.LoginService;
import ua.dragun.agileboard.service.ticketservice.TicketService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private LoginService signService;

   @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/tickets")
    public String ticket(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            User user = signService.findByUsername(session.getAttribute("username").toString());
            model.addAttribute("username", user.getUsername());
            model.addAttribute("tickets", user.getTickets());
            return "ticket";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/tickets/add")
    public String add(HttpSession session,
                      Model model) {
        if (session.getAttribute("username") != null) {
            User user = signService.findByUsername(session.getAttribute("username").toString());
            model.addAttribute("username", user.getUsername());
            return "adds";
        } else {
            return "redirect:/";
        }
    }


  /*  @RequestMapping(value = "/tickets/delete", method = RequestMethod.POST)
    @ResponseBody
    public void remove(@RequestParam Integer ticketId,
                  HttpSession session,
                  Model model) {
        return TicketService.remove(ticketId, session.getAttribute("username").toString())
                .toString();
    }*/

    @RequestMapping(value = "/logOut")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
