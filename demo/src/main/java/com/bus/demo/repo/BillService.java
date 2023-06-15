package com.bus.demo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.demo.entity.Bill;
import com.bus.demo.entity.Ticket;
import com.bus.demo.entity.User;

@Service
public class BillService implements IBill{
@Autowired
BillRepo billRepo;
@Autowired
UserRepo repo;
@Autowired
TicketRepo ticketRepo;
	@Override
	public boolean addBill(Bill bill) {
		User user = repo.findByPhoneNumber(bill.getUser().getPhoneNumber());
		boolean check = false;
		if(user == null)
		{
			check = false;
		}
		else
		{
			bill.setUser(user);
			Ticket  ticket = ticketRepo.findById(bill.getTickets().getTicketId());
			if(ticket == null)
			{
				check =false;
			}
			else
			{
				bill.setTickets(ticket);
				int total = 0;
				for(int i=0;i<ticket.getSeats().size();i++)
				{
					total += ticket.getSeats().get(i).getSeatPrice();
				}
				bill.setTotalPrice(total);
				billRepo.save(bill);
				check = true;
			}
		}
		return check;	
		
		
	}

}
