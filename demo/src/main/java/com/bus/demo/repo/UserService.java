package com.bus.demo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.demo.entity.User;

import jakarta.persistence.Entity;

@Service
public class UserService  implements IUser{
@Autowired
UserRepo repo;
	@Override
	public User findByPhoneNumber(int phoneNumber) {
		
		return repo.findByPhoneNumber(phoneNumber);
	}

	@Override
	public User save(User user) {
		
		return repo.save(user);
	}

}
