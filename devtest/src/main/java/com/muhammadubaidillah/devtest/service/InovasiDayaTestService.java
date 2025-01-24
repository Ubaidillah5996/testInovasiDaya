package com.muhammadubaidillah.devtest.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import com.muhammadubaidillah.devtest.common.Constant;
import com.muhammadubaidillah.devtest.common.ResponseUtil;
import com.muhammadubaidillah.devtest.dto.InovasiReq;
import com.muhammadubaidillah.devtest.dto.InovasiResp;
import com.muhammadubaidillah.devtest.model.Inovasi;
import com.muhammadubaidillah.devtest.model.StatusInovasi;
import com.muhammadubaidillah.devtest.repository.InovasiRepository;
import com.muhammadubaidillah.devtest.repository.StatusInovasiRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;


@ApplicationScoped
public class InovasiDayaTestService {
	
	@Inject
	InovasiRepository inovasiRepository;
	
	@Inject
	StatusInovasiRepository statusInovasiRepository;
	
	@Transactional
	public Response saveInovasi(List<InovasiReq> lsReq) {
		ResponseUtil responseUtils = new ResponseUtil();
		responseUtils.status = "SUCCESS";
		
		for (InovasiReq req : lsReq) {
			Inovasi inIns = new Inovasi();
			inIns.productId = req.productId;
			inIns.productName = req.productName;
			inIns.customerName = req.customerName;
			inIns.amount = req.amount;
			inIns.createdBy = req.createdBy;
			inIns.status = req.status;
			inIns.transactionDate = new Date();
			inIns.createdOn = new Date();
			inovasiRepository.persist(inIns);
		}
		
		return Response.status(200).entity(JsonObject.mapFrom(responseUtils)).build();
		
	}
	
	@Transactional
	public InovasiResp getAll() {
		InovasiResp joResponse = new InovasiResp();

		PanacheQuery<StatusInovasi> lsStatus = null;
		
		lsStatus = statusInovasiRepository.findAll();
		
		List<StatusInovasi> lsStatusInv = lsStatus.list();
		
		joResponse.status = lsStatusInv;
		
		PanacheQuery<Inovasi> lsData = null;
		
		lsData = inovasiRepository.findAll();
		
		List<Inovasi> lsDataInv = lsData.list();	
		
		joResponse.data = lsDataInv;
		
		return joResponse;
		
	}
	
}
