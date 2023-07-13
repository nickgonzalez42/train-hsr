package com.nickgonzalez.trainhsr.service;

import com.nickgonzalez.trainhsr.entity.Ticket;

public interface TicketService {
    Ticket save(Ticket ticket);
    Ticket findById(int id);
}
