package com.mgr.pickMeCar.db.dao;

import java.util.List;

import com.mgr.pickMeCar.db.model.Token;

public interface TokenDAO {
	public List<Token> list();

	public Token get(int id);

	public void saveOrUpdate(Token token);

	public void delete(int id);
}
