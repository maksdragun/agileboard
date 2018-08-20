package ua.dragun.agileboard.dao.ticket;

import org.springframework.data.repository.CrudRepository;
import ua.dragun.agileboard.entity.ticket.Ticket;

public interface TicketDao extends CrudRepository<Ticket, String> {

}
