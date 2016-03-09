package com.mgr.pickMeCar.db.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.mgr.pickMeCar.db.model.Through;

public class ThroughDAOImpl implements ThroughDAO {
	private SessionFactory sessionFactory;

	public ThroughDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Through> list() {
		@SuppressWarnings("unchecked")
		List<Through> listUser = (List<Through>) sessionFactory.getCurrentSession().createCriteria(Through.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	@Override
	@Transactional
	public Through get(int id) {
		String hql = "from Through where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Through> listThrough = (List<Through>) query.list();

		if (listThrough != null && !listThrough.isEmpty()) {
			return listThrough.get(0);
		}

		return null;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Through through) {
		sessionFactory.getCurrentSession().saveOrUpdate(through);

	}

	@Override
	@Transactional
	public void delete(int id) {
		Through throughToDelete = new Through();
		throughToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(throughToDelete);
	}

}
