package com.bus.demo.repo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bus.demo.entity.Schedual;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedual, Long> {
	@Query("SELECT DISTINCT s.startTime FROM Schedual s WHERE s.bus.busId=:busId AND s.startDate=:startDate")
	List<String> getStartTimeByBusIdAndStartDate(@Param("busId") Long busId,@Param("startDate") String startDate);

	public Schedual findById(long schedualId);

	Schedual getSchedualsByStartTime(String startTime);
	
	@Query("SELECT DISTINCT s FROM Schedual s WHERE s.bus.busId=:busId AND s.startDate=:startDate AND s.startTime=:startTime")
	public List<Schedual> findByBusIdAndStartDateAndStartTime(@Param("busId") long busId,@Param("startDate") String startDate,@Param("startTime")String startTime);
}
