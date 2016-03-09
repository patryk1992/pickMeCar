package com.mgr.pickMeCar.db.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.mgr.pickMeCar.db.model.UserGroup;

public class UserGroupDAOImpl implements UserGroupDAO {
	private SessionFactory sessionFactory;

	public UserGroupDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<UserGroup> list() {
		@SuppressWarnings("unchecked")
		List<UserGroup> listUser = (List<UserGroup>) sessionFactory.getCurrentSession().createCriteria(UserGroup.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	@Override
	@Transactional
	public UserGroup get(int id) {
		String hql = "from UserGroup where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<UserGroup> listUserGroup = (List<UserGroup>) query.list();

		if (listUserGroup != null && !listUserGroup.isEmpty()) {
			return listUserGroup.get(0);
		}

		return null;
	}

	@Override
	@Transactional
	public void saveOrUpdate(UserGroup userGroup) {
		sessionFactory.getCurrentSession().saveOrUpdate(userGroup);

	}

	@Override
	@Transactional
	public void delete(int id) {
		UserGroup userGroupToDelete = new UserGroup();
		userGroupToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(userGroupToDelete);
	}

}
