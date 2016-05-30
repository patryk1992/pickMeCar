package com.mgr.pickMeCar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mgr.pickMeCar.db.model.Mark;
import com.mgr.pickMeCar.db.model.User;
import com.mgr.pickMeCar.db.repository.MarkRepository;
import com.mgr.pickMeCar.db.repository.UserRepository;

@Service
public class MarkServiceImpl implements MarkService {
	@Autowired
	private MarkRepository markRepository;

	@Override
	public List<Mark> list() {
		return (List<Mark>) markRepository.findAll();
	}

	@Override
	public Mark get(int id) {
		return markRepository.findOne(id);
	}

	@Override
	public Mark saveOrUpdate(Mark mark) {

		return markRepository.save(mark);

	}
	@Override
	public void delete(int id) {
		markRepository.delete(id);

	}

}
