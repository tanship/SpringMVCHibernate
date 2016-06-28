package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Nationality;
import com.journaldev.spring.model.Person;

public interface NationalityService {

	public void addNationality(Nationality p);

	public void updateNationality(Nationality p);

	public List<Nationality> listNationalities();

	public Nationality getNationalityById(int id);

	public void removeNationality(int id);

}
