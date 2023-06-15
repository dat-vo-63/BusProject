package com.bus.demo.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.demo.entity.Bus;
import com.bus.demo.entity.Schedual;
import com.bus.demo.entity.Seat;

@Service
public class ScheduleService implements ISchedule{
@Autowired
ScheduleRepo repo;
@Autowired 
BusRepo busRepo;
@Autowired
SeatRepo seatRepo;
	@Override
	public boolean bookSeat(long scheduleId, List<Seat> seat) {
//		Schedual schedual = repo.findById(scheduleId);
//		boolean check = false;
//		if(schedual ==null)
//		{
//			check= false;
//		}
//		else
//		{
//			List<Seat> list = schedual.getSeats();
//			for(int i=0;i < seat.size();i++ )
//			{
//				if(list.contains(seat.get(i)))
//				{
//					check = false;
//					break;
//				}
//				else
//				{
//					list.add(seat.get(i));
//					schedual.setSeats(list);
//					schedual.setSeatLeft(schedual.getTotalSeat()-schedual.getSeats().size());
//					repo.save(schedual);
//					check = true;
//				}
//			}
//		}
//		return check;
		return true;
	}
	@Override
	public Schedual saveSchedual(Schedual schedual) {
		List<Seat> seats = new ArrayList<>();
		for(int i=1;i<=schedual.getTotalSeat();i++)
		{
			Seat seat = new Seat();
			seat.setSeatNo(Integer.toString(i));
			seat.setSchedual(schedual);
			if(i >= 90)
			{
				seat.setSeatPrice(90000);
			}
			else
			{
				seat.setSeatPrice(50000);
			}
			seatRepo.save(seat);
			seats.add(seat);
		}
		schedual.setSeats(seats);
		
		return repo.save(schedual);
	}
	@Override
	public Schedual findScheduleByStartTime(String starttime) {
		Schedual list= repo.getSchedualsByStartTime(starttime);
		
			
		return list;
	}
	@Override
	public Schedual updateSchedule(long id,Schedual schedual) {
		Schedual schedual2 = null; 
			schedual2 =	repo.findById(id);
			if(schedual2 == null)
			{}
			else
			{
				schedual2.setStartDate(schedual.getStartDate());
				schedual2.setStartTime(schedual.getStartTime());
				schedual2.setTotalSeat(schedual.getTotalSeat());
				schedual2.setSeatLeft(schedual.getSeatLeft());
				schedual2.setEndTime(schedual.getEndTime());
				repo.save(schedual2);
			}
		return schedual2;
	}
	@Override
	public List<String> getStartTime(long busId, String startDate) {
		
		return repo.getStartTimeByBusIdAndStartDate(busId, startDate);
	}
	@Override
	public List<Schedual> findScheduleByBusIdAndStartDateAndStartTime(long busId, String startDate, String startTime) {
		
		return repo.findByBusIdAndStartDateAndStartTime(busId, startDate, startTime);
	}
	@Override
	public Schedual findScheduleById(long id) {
		
		return repo.findById(id);
	}

}
