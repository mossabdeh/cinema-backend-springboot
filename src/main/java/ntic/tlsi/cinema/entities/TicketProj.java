package ntic.tlsi.cinema.entities;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ticketProj",types = Ticket.class)
public interface TicketProj {

    public Long getId();
    public String nomClient();

    public double getPrix();
    public Integer getCodePayment();
    public boolean getReserve();
    public Place getPlace();
}
