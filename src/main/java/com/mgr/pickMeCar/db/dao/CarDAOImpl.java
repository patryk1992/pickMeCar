package com.mgr.pickMeCar.db.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.mgr.pickMeCar.db.model.Car;

public class CarDAOImpl implements CarDAO {
	private SessionFactory sessionFactory;

	public CarDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Car> list() {
		@SuppressWarnings("unchecked")
		List<Car> listUser = (List<Car>) sessionFactory.getCurrentSession().createCriteria(Car.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	@Override
	@Transactional
	public Car get(int id) {
		String hql = "from Car where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Car> listCar = (List<Car>) query.list();

		if (listCar != null && !listCar.isEmpty()) {
			return listCar.get(0);
		}

		return null;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Car car) {
		sessionFactory.getCurrentSession().saveOrUpdate(car);

	}

	@Override
	@Transactional
	public void delete(int id) {
		Car carToDelete = new Car();
		carToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(carToDelete);
	}

}
