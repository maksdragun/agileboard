package ua.dragun.agileboard.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

@Entity
@Document(collection="tickets")
public class Ticket {

    @Id
    private Integer id;
    private String title;
    private String description;
    private TicketStatus status;

    @DBRef
    private User user;

    private Ticket() {}

    public Ticket(Integer id, String title, String description, TicketStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id = " + id +
                ", title = '" + title + '\'' +
                ", description ='" + description + '\'' +
                ", status =" + status +
                ", user =" + user +
                '}';
    }
}
