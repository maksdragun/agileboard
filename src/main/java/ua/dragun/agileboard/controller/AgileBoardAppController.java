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
import java.math.BigInteger;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private LoginService signService;

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/agileBoardApp")
    public String agileBoardApp(HttpSession session, Model model) {
        if (session.getAttribute("username") != null) {
            User user = signService.findByUsername(session.getAttribute("username").toString());
            model.addAttribute("username", user.getUsername());
            model.addAttribute("tickets", user.getTickets());
            return "tickets";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/agileBoardApp/add")
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


    /* @RequestMapping(value = "/tickets/addNew", method = RequestMethod.POST)
     public String addNew(@RequestParam String surname,
                          @RequestParam String firstName,
                          @RequestParam String patronymic,
                          @RequestParam String mobilePhone,
                          @RequestParam String homePhone,
                          @RequestParam String address,
                          @RequestParam String email,
                          HttpSession session,
                          RedirectAttributes redirectAttributes) {
         User user = signService.findByUsername(session.getAttribute("username").toString());
         Ticket ticket = new Ticket(surname, firstName, patronymic, mobilePhone, homePhone, address, email, user);
         LoginStatus status = TicketService.add(ticket, user.getUsername());
         switch (status) {
             case INCORRECT_SURNAME:
                 redirectAttributes.addFlashAttribute("message", "Surname must contain at least 4 symbols");
                 return "redirect:/tickets/add";
             case INCORRECT_FIRSTNAME:
                 redirectAttributes.addFlashAttribute("message", "First Name must contain at least 4 symbols");
                 return "redirect:/tickets/add";
             case INCORRECT_PATRONYMIC:
                 redirectAttributes.addFlashAttribute("message", "Patronymic must contain at least 4 symbols");
                 return "redirect:/tickets/add";
             case INCORRECT_MOBILE:
                 redirectAttributes.addFlashAttribute("message", "Mobile phone must have format: +XXX(XX)XXX-XX-XX");
                 return "redirect:/tickets/add";
             case INCORRECT_HOME:
                 redirectAttributes.addFlashAttribute("message", "Home phone must have format: +XXX(XX)XXX-XX-XX");
                 return "redirect:/tickets/add";
             case INCORRECT_EMAIL:
                 redirectAttributes.addFlashAttribute("message", "Email must have format: test@example.com");
                 return "redirect:/tickets/add";
             case SUCCESS:
                 redirectAttributes.addFlashAttribute("message", "New entry added");
                 return "redirect:/tickets/add";
         }
         return "redirect:/tickets/add";
     }

     @RequestMapping(value = "/tickets/edit/{ticketId}")
     public String edit(HttpSession session,
                        @PathVariable String ticketId,
                        Model model) {
         if (session.getAttribute("username") != null) {
             model.addAttribute("username", session.getAttribute("username").toString());
             model.addAttribute("ticketId", ticketId);
             return "edits";
         }
         return "redirect:/";
     }


     @RequestMapping(value = "/tickets/editTicket", method = RequestMethod.POST)
     public String editTicket(@RequestParam BigInteger ticketId,
                               @RequestParam String surname,
                               @RequestParam String firstName,
                               @RequestParam String patronymic,
                               @RequestParam String mobilePhone,
                               @RequestParam String homePhone,
                               @RequestParam String address,
                               @RequestParam String email,
                               HttpSession session,
                               RedirectAttributes redirectAttributes) {
         User user = signService.findByUsername(session.getAttribute("username").toString());
         Ticket ticket = new Ticket(ticketId.toString(), surname, firstName, patronymic, mobilePhone, homePhone, address, email, user);
         LoginStatus status = TicketService.add(ticket, user.getUsername());
         switch (status) {
             case INCORRECT_SURNAME:
                 redirectAttributes.addFlashAttribute("message", "Surname must contain at least 4 symbols");
                 return "redirect:/tickets/edit/" + ticketId;
             case INCORRECT_FIRSTNAME:
                 redirectAttributes.addFlashAttribute("message", "First Name must contain at least 4 symbols");
                 return "redirect:/tickets/edit/" + ticketId;
             case INCORRECT_PATRONYMIC:
                 redirectAttributes.addFlashAttribute("message", "Patronymic must contain at least 4 symbols");
                 return "redirect:/tickets/edit/" + ticketId;
             case INCORRECT_MOBILE:
                 redirectAttributes.addFlashAttribute("message", "Mobile phone must have format: +XXX(XX)XXX-XX-XX");
                 return "redirect:/tickets/edit/" + ticketId;
             case INCORRECT_HOME:
                 redirectAttributes.addFlashAttribute("message", "Home phone must have format: +XXX(XX)XXX-XX-XX");
                 return "redirect:/tickets/edit/" + ticketId;
             case INCORRECT_EMAIL:
                 redirectAttributes.addFlashAttribute("message", "E-mail must have format: test@example.com");
                 return "redirect:/tickets/edit/" + ticketId;
             case SUCCESS:
                 redirectAttributes.addFlashAttribute("message", "Ticket Changed");
                 return "redirect:/tickets/edit/" + ticketId;
         }
         return "redirect:/tickets/edit/" + ticketId;
     }

 */
   /* @RequestMapping(value = "/agileBoardApp/delete", method = RequestMethod.POST)
    @ResponseBody
    String remove(@RequestParam Ticket ticket,
                       HttpSession session,
                       Model model) {
      return  ticketService.remove(ticket, session.getAttribute("username").toString());
    }*/

    @RequestMapping(value = "/logOut")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
