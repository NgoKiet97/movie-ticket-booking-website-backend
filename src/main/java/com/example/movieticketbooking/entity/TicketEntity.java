package com.example.movieticketbooking.entity;

import com.example.movieticketbooking.entity.ids.Ticketids;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "ticket")
@Getter @Setter
public class TicketEntity {

    @EmbeddedId
    Ticketids ids;

    @ManyToOne
    @JoinColumn(name = "show_movie_id", insertable = false,updatable = false)
    private ShowMovieEntity showMovie;

    @ManyToOne
    @JoinColumn(name = "seat_id", insertable = false,updatable = false)
    private SeatEntity seat;

    @Column(name = "guest_name")
    private String guestName;

    @ManyToOne
    @JoinColumn(name = "type_ticket_id")
    private TypeTicketEntity typeTicket;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private BillEntity bill;

    @ManyToOne
    @JoinColumn(name = "state_ticket_id")
    private StateTicketEntity stateTicket;
}
