package ua.dragun.agileboard.service.ticketservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dragun.agileboard.dao.ticket.TicketDao;
import ua.dragun.agileboard.entity.ticket.Ticket;
import ua.dragun.agileboard.service.enums.LoginStatus;
import ua.dragun.agileboard.service.enums.TicketStatus;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketDao ticketDao;

    @Autowired
    public TicketServiceImpl(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }


    @Override
    public LoginStatus add(Ticket ticket, String userName) {
        if(ticket.getName().length() < 1) {
            return LoginStatus.INCORRECT_TITLE;
        } else if (ticket.getDescription().length() < 1) {
            return LoginStatus.INCORRECT_DESCRIPTION;
        } else {
            ticketDao.save(ticket);
            return LoginStatus.SUCCESS;
        }
    }

    @Override
    public void remove(Ticket ticket, String userName) {
           ticketDao.delete(ticket);
        }
    @Override
    @SuppressWarnings("unchecked")
    public List<Ticket> findByUserId(Integer id){
        return (List<Ticket>) ticketDao.findById(Integer.toString(id)).get();
    }

    @Override
    public void setStatus(Integer id, TicketStatus status){
        Ticket ticket = ticketDao.findById(Integer.toString(id)).get();
        ticket.setState(status);
        ticketDao.save(ticket);
    }

}
