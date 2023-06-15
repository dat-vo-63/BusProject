package com.bus.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.demo.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Long>  {
public Ticket findById(long id);

}
