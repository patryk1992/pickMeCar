package com.mgr.pickMeCar.db.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.mgr.pickMeCar.db.model.City;

public class CityDAOImpl implements CityDAO {
	private SessionFactory sessionFactory;

	public CityDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<City> list() {
		@SuppressWarnings("unchecked")
		List<City> listUser = (List<City>) sessionFactory.getCurrentSession().createCriteria(City.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	@Override
	@Transactional
	public City get(int id) {
		String hql = "from City where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<City> listCity = (List<City>) query.list();

		if (listCity != null && !listCity.isEmpty()) {
			return listCity.get(0);
		}

		return null;
	}

	@Override
	@Transactional
	public void saveOrUpdate(City city) {
		sessionFactory.getCurrentSession().saveOrUpdate(city);

	}

	@Override
	@Transactional
	public void delete(int id) {
		City cityToDelete = new City();
		cityToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(cityToDelete);
	}

}
