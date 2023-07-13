package com.nickgonzalez.trainhsr.service;

import com.nickgonzalez.trainhsr.dao.TicketRepository;
import com.nickgonzalez.trainhsr.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService{
    private TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket findById(int id) {
        Optional<Ticket> result = ticketRepository.findById(id);

        Ticket ticket = null;

        if (result.isPresent()) {
            ticket = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find ticket id - " + id);
        }

        return ticket;
    }
}
