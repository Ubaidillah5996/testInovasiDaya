package com.muhammadubaidillah.devtest.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.muhammadubaidillah.devtest.model.Inovasi;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class InovasiRepository implements PanacheRepository<Inovasi> {

	public List<Inovasi> findByIdList() {
		return findAll().list();
	}
	
	public Inovasi findById(String id) {
		return find("id=?1", id).firstResult();
	}

}