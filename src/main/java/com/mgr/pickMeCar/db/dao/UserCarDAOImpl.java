package com.mgr.pickMeCar.db.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.mgr.pickMeCar.db.model.UserCar;

public class UserCarDAOImpl implements UserCarDAO {
	private SessionFactory sessionFactory;

	public UserCarDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<UserCar> list() {
		@SuppressWarnings("unchecked")
		List<UserCar> listUser = (List<UserCar>) sessionFactory.getCurrentSession().createCriteria(UserCar.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	@Override
	@Transactional
	public UserCar get(int id) {
		String hql = "from UserCar where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<UserCar> listUserCar = (List<UserCar>) query.list();

		if (listUserCar != null && !listUserCar.isEmpty()) {
			return listUserCar.get(0);
		}

		return null;
	}

	@Override
	@Transactional
	public void saveOrUpdate(UserCar userCar) {
		sessionFactory.getCurrentSession().saveOrUpdate(userCar);

	}

	@Override
	@Transactional
	public void delete(int id) {
		UserCar userCarToDelete = new UserCar();
		userCarToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(userCarToDelete);
	}

}
