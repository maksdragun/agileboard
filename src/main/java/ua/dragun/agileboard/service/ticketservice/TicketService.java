package ua.dragun.agileboard.service.ticketservice;

import ua.dragun.agileboard.entity.ticket.Ticket;
import ua.dragun.agileboard.service.enums.LoginStatus;
import ua.dragun.agileboard.service.enums.TicketStatus;

import java.util.List;

public interface TicketService {

    LoginStatus add(Ticket ticket,String userName );
    void remove(Ticket ticket, String userName);
    List<Ticket> findByUserId(Integer id);
    void setStatus(Integer id, TicketStatus status);



}
