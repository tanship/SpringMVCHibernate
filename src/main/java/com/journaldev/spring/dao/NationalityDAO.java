package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Nationality;

public interface NationalityDAO {
	public void addNationality(Nationality p);

	public void updateNationality(Nationality p);

	public List<Nationality> listNationalities();

	public Nationality getNationalityById(int id);

	public void removeNationality(int id);
}
