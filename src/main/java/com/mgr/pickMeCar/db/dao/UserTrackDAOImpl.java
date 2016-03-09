package com.mgr.pickMeCar.db.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.mgr.pickMeCar.db.model.UserTrack;

public class UserTrackDAOImpl implements UserTrackDAO {
	private SessionFactory sessionFactory;

	public UserTrackDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<UserTrack> list() {
		@SuppressWarnings("unchecked")
		List<UserTrack> listUser = (List<UserTrack>) sessionFactory.getCurrentSession().createCriteria(UserTrack.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	@Override
	@Transactional
	public UserTrack get(int id) {
		String hql = "from UserTrack where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<UserTrack> listUserTrack = (List<UserTrack>) query.list();

		if (listUserTrack != null && !listUserTrack.isEmpty()) {
			return listUserTrack.get(0);
		}

		return null;
	}

	@Override
	@Transactional
	public void saveOrUpdate(UserTrack userTrack) {
		sessionFactory.getCurrentSession().saveOrUpdate(userTrack);

	}

	@Override
	@Transactional
	public void delete(int id) {
		UserTrack userTrackToDelete = new UserTrack();
		userTrackToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(userTrackToDelete);
	}

}
