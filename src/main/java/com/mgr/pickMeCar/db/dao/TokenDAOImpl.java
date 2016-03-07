package com.mgr.pickMeCar.db.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.mgr.pickMeCar.db.model.Token;

public class TokenDAOImpl implements TokenDAO {
	private SessionFactory sessionFactory;

	public TokenDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Token> list() {
		@SuppressWarnings("unchecked")
		List<Token> listUser = (List<Token>) sessionFactory.getCurrentSession().createCriteria(Token.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

}
