package com.mgr.pickMeCar.db.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.mgr.pickMeCar.db.model.Track;

public class TrackDAOImpl implements TrackDAO {
	private SessionFactory sessionFactory;

	public TrackDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Track> list() {
		@SuppressWarnings("unchecked")
		List<Track> listUser = (List<Track>) sessionFactory.getCurrentSession().createCriteria(Track.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	@Override
	@Transactional
	public Track get(int id) {
		String hql = "from Track where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Track> listTrack = (List<Track>) query.list();

		if (listTrack != null && !listTrack.isEmpty()) {
			return listTrack.get(0);
		}

		return null;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Track track) {
		sessionFactory.getCurrentSession().saveOrUpdate(track);

	}

	@Override
	@Transactional
	public void delete(int id) {
		Track trackToDelete = new Track();
		trackToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(trackToDelete);
	}

}
