package com.mgr.pickMeCar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgr.pickMeCar.db.model.User;
import com.mgr.pickMeCar.db.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> list() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User get(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public User saveOrUpdate(User user) {
		return userRepository.save(user);

	}

	@Override
	public void delete(int id) {
		userRepository.delete(id);

	}

}
