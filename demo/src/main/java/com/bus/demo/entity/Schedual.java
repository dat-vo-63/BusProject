package com.bus.demo.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@JsonSerialize
@Entity
@Table(name = "schedule")
public class Schedual implements Comparable<Schedual>{
@Id
@GeneratedValue
@Column(name = "schedule_id")
private Long scheduleId;
@Column( name = "start_time")
private String startTime;
@Column( name = "end_time")
private String endTime;
@Column(name = "totalSeat")
private int totalSeat;
@Column  (name = "seatLeft")
private int seatLeft;
@Column(name = "startDate")
private String startDate;

public String getStartDate() {
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
public int getSeatLeft() {
	return seatLeft;
}
@Override
public String toString() {
	return "Schedual [scheduleId=" + scheduleId + ", startTime=" + startTime + ", endTime=" + endTime + ", totalSeat="
			+ totalSeat + ", seatLeft=" + seatLeft + ", bus=" + bus.toString() + ", seats="  + "]";
}
public void setSeatLeft(int seatLeft) {
	this.seatLeft = seatLeft;
}
@ManyToOne(targetEntity = Bus.class,cascade =  CascadeType.ALL)
@JoinColumn(name = "bus_id")
private Bus bus;
public int getTotalSeat() {
	return totalSeat;
}
public void setTotalSeat(int totalSeat) {
	this.totalSeat = totalSeat;
}
@OneToMany (mappedBy = "schedual",cascade = CascadeType.ALL)
private List<Seat> seats;
public List<Seat> getSeats() {
	return seats;
}
public void setSeats(List<Seat> seats) {
	this.seats = seats;
}
public Long getScheduleId() {
	return scheduleId;
}
public void setScheduleId(Long scheduleId) {
	this.scheduleId = scheduleId;
}

public String getStartTime() {
	return startTime;
}
public void setStartTime(String startTime) {
	this.startTime = startTime;
}
public String getEndTime() {
	return endTime;
}
public void setEndTime(String endTime) {
	this.endTime = endTime;
}
public Bus getBus() {
	return bus;
}
public void setBus(Bus bus) {
	this.bus = bus;
}
//public List<Seat> getSeats() {
//	return seats;
//}
//public void setSeats(List<Seat> seats) {
//	this.seats = seats;

@Override
public int compareTo(Schedual o) {
	// TODO Auto-generated method stub
	return 0;
}
}
