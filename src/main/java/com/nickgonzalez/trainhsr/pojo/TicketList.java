package com.nickgonzalez.trainhsr.pojo;

import com.nickgonzalez.trainhsr.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
public class TicketList {
    private List<Ticket> tickets = new ArrayList<>();
    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }
}