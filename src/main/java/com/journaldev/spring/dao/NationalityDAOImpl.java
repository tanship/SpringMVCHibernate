package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Nationality;

@Repository
public class NationalityDAOImpl implements NationalityDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(PersonDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addNationality(Nationality p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Nationality saved successfully, Person Details=" + p);
	}

	@Override
	public void updateNationality(Nationality p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Nationality updated successfully, Person Details=" + p);

	}

	@Override
	public List<Nationality> listNationalities() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Nationality> nationalitysList = session.createQuery(
				"from Nationality").list();
		for (Nationality p : nationalitysList) {
			logger.info("Nationality List::" + p);
		}
		return nationalitysList;
	}

	@Override
	public Nationality getNationalityById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Nationality p = (Nationality) session.load(Nationality.class,
				new Integer(id));
		logger.info("Nationality loaded successfully, Nationality details=" + p);
		return p;
	}

	@Override
	public void removeNationality(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Nationality p = (Nationality) session.load(Nationality.class,
				new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("Nationality deleted successfully, Nationality details="
				+ p);

	}

}
