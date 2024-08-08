package org.practice.example.parkinglot.dao;

import org.practice.example.parkinglot.entity.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class BookedSpotDAO {
    private static final Logger log = LoggerFactory.getLogger(BookedSpotDAO.class);
    HashMap<String, Ticket> bookedMap;

    public BookedSpotDAO() {
        this.bookedMap= new HashMap<>();
    }

    public void addTicket(Ticket ticket){
        if(this.bookedMap.containsKey(ticket.getTicketId())){
            //Throw exception
        }
        this.bookedMap.put(ticket.getTicketId(),ticket);
        log.info("Successfully added Ticket :{} in booking list",ticket.getTicketId());
    }

    public Ticket findTicket(String ticketId){

        if(this.bookedMap.containsKey(ticketId)){
            return this.bookedMap.get(ticketId);
        }

        log.error("No Ticket Found");
        return null;
    }
}
