package com.nickgonzalez.trainhsr.dao;

import com.nickgonzalez.trainhsr.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
