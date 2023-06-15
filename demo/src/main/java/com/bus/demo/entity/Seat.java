package com.bus.demo.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

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

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@JsonIgnoreType
@Table(name = "seat")
public class Seat implements Comparable<Seat> {
	@Override
	public String toString() {
		return "Seat [seatNo=" + seatNo + ", seatPrice=" + seatPrice + "]";
	}
	@Id
	@GeneratedValue
	private  long seatId;
	@Column(name = "seatNo")
	private String seatNo;
	@Column (name = "seatPrice")
	private int seatPrice;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ticketId")
	private Ticket ticket;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "schedule_id")
	private Schedual schedual;
	public Schedual getSchedual() {
		return schedual;
	}
	public void setSchedual(Schedual schedual) {
		this.schedual = schedual;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public int getSeatPrice() {
		return seatPrice;
	}
	public void setSeatPrice(int seatPrice) {
		this.seatPrice = seatPrice;
	}
	public long getSeatId() {
		return seatId;
	}
	public void setSeatId(long seatId) {
		this.seatId = seatId;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	@Override
	public int compareTo(Seat o) {
		
		return (int) (this.getSeatId()-o.seatId);
	}
	@Override
	public int hashCode() {
		return Objects.hash(seatNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		return  Objects.equals(seatNo, other.seatNo);
	}

}
