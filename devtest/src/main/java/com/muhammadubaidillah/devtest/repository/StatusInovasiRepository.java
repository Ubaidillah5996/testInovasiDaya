package com.muhammadubaidillah.devtest.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.muhammadubaidillah.devtest.model.Inovasi;
import com.muhammadubaidillah.devtest.model.StatusInovasi;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class StatusInovasiRepository implements PanacheRepository<StatusInovasi> {

	public List<StatusInovasi> findByIdList() {
		return findAll().list();
	}
	
	public StatusInovasi findById(String id) {
		return find("id=?1", id).firstResult();
	}

}