package com.mgr.pickMeCar.db.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.mgr.pickMeCar.db.model.Mark;

public class MarkDAOImpl implements MarkDAO {
	private SessionFactory sessionFactory;

	public MarkDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Mark> list() {
		@SuppressWarnings("unchecked")
		List<Mark> listUser = (List<Mark>) sessionFactory.getCurrentSession().createCriteria(Mark.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	@Override
	@Transactional
	public Mark get(int id) {
		String hql = "from Mark where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Mark> listMark = (List<Mark>) query.list();

		if (listMark != null && !listMark.isEmpty()) {
			return listMark.get(0);
		}

		return null;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Mark mark) {
		sessionFactory.getCurrentSession().saveOrUpdate(mark);

	}

	@Override
	@Transactional
	public void delete(int id) {
		Mark markToDelete = new Mark();
		markToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(markToDelete);
	}

}
