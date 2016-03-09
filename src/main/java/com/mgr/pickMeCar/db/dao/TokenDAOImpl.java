package com.mgr.pickMeCar.db.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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

	@Override
	@Transactional
	public Token get(int id) {
		String hql = "from Token where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Token> listToken = (List<Token>) query.list();

		if (listToken != null && !listToken.isEmpty()) {
			return listToken.get(0);
		}

		return null;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Token token) {
		sessionFactory.getCurrentSession().saveOrUpdate(token);

	}

	@Override
	@Transactional
	public void delete(int id) {
		Token tokenToDelete = new Token();
		tokenToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(tokenToDelete);
	}

}
