package com.bus.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.demo.entity.Bill;

@Repository
public interface BillRepo extends JpaRepository<Bill, Long>{

}
