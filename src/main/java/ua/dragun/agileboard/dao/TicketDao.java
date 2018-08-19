package ua.dragun.agileboard.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.dragun.agileboard.entity.Ticket;
import ua.dragun.agileboard.entity.User;

import java.util.List;

public interface TicketDao extends MongoRepository<Ticket, String> {
    List<Ticket> findAllByUser(User user);
}
