package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.NationalityDAO;
import com.journaldev.spring.dao.PersonDAO;
import com.journaldev.spring.model.Nationality;
import com.journaldev.spring.model.Person;

@Service
public class NationalityServiceImpl implements NationalityService {

	private NationalityDAO nationalityDAO;

	public void setNationalityDAO(NationalityDAO nationalityDAO) {
		this.nationalityDAO = nationalityDAO;
	}

	@Override
	@Transactional
	public void addNationality(Nationality p) {
		this.nationalityDAO.addNationality(p);
	}

	@Override
	@Transactional
	public void updateNationality(Nationality p) {
		this.nationalityDAO.updateNationality(p);
	}

	@Override
	@Transactional
	public List<Nationality> listNationalities() {
		return this.nationalityDAO.listNationalities();
	}

	@Override
	@Transactional
	public Nationality getNationalityById(int id) {
		return this.nationalityDAO.getNationalityById(id);
	}

	@Override
	@Transactional
	public void removeNationality(int id) {
		this.nationalityDAO.removeNationality(id);
	}

}
