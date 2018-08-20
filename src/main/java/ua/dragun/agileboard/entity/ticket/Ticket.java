package ua.dragun.agileboard.entity.ticket;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ua.dragun.agileboard.service.enums.TicketStatus;


@Document(collection = Ticket.COLLECTION_NAME)
public class Ticket {
    public static final String COLLECTION_NAME = "tickets";
    @Id
    private Integer id;
    private Integer userId;
    private String name;
    private String description;
    private TicketStatus status;

    public Ticket(String name, String description, TicketStatus status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Ticket() {
    }

    public Ticket(Integer userId, String name, String description, TicketStatus status) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.status = status;
    }
    public Ticket(Integer id, Integer userId, String name, String description, TicketStatus status) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public static String getCollectionName() {
        return COLLECTION_NAME;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TicketStatus getState() {
        return status;
    }

    public void setState(TicketStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}