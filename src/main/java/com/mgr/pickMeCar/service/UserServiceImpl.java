package com.mgr.pickMeCar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mgr.pickMeCar.db.model.User;
import com.mgr.pickMeCar.db.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
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
		String encodedPassword=passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepository.save(user);

	}

	@Override
	public void delete(int id) {
		userRepository.delete(id);

	}

	@Override
	public User findOneByUserName(String name) {		
		return userRepository.findOneByUserName(name);
	}

	@Override
	public List<User> findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	

}
