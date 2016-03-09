package com.mgr.pickMeCar.db.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.mgr.pickMeCar.db.model.Groups;

public class GroupsDAOImpl implements GroupsDAO {
	private SessionFactory sessionFactory;

	public GroupsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Groups> list() {
		@SuppressWarnings("unchecked")
		List<Groups> listUser = (List<Groups>) sessionFactory.getCurrentSession().createCriteria(Groups.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	@Override
	@Transactional
	public Groups get(int id) {
		String hql = "from Groups where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Groups> listGroups = (List<Groups>) query.list();

		if (listGroups != null && !listGroups.isEmpty()) {
			return listGroups.get(0);
		}

		return null;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Groups groups) {
		sessionFactory.getCurrentSession().saveOrUpdate(groups);

	}

	@Override
	@Transactional
	public void delete(int id) {
		Groups groupsToDelete = new Groups();
		groupsToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(groupsToDelete);
	}

}
