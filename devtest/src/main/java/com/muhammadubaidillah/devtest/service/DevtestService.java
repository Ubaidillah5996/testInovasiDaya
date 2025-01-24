package com.muhammadubaidillah.devtest.service;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.muhammadubaidillah.devtest.dto.DevtestReq;
import com.muhammadubaidillah.devtest.dto.DevtestResp;
import com.muhammadubaidillah.devtest.model.Devtest;
import com.muhammadubaidillah.devtest.repository.DevtestRepository;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

@ApplicationScoped
public class DevtestService {
	
	@Inject
	DevtestRepository devtestRepository;
	
	@Transactional
	public DevtestResp saveUpdate(DevtestReq req) {
		DevtestResp joResponse = new DevtestResp();
		joResponse.status = "SUCCESS";
		
		if(req.id != null) {
			//UPDATE
			Devtest devUpdate = devtestRepository.findById(req.id);
			devUpdate.name = req.name;
			devUpdate.phone = req.phone;
			devUpdate.updatedDate = new Date();
			devUpdate.updatedBy = "admin";
			devtestRepository.persist(devUpdate);
			joResponse.data = devUpdate.id;
		} else {
			//INSERT
			Devtest dev = new Devtest();
			dev.name = req.name;
			dev.phone = req.phone;
			dev.createdDate = new Date();
			dev.createdBy = "admin";
			devtestRepository.persist(dev);
			joResponse.data = dev.id;
		}
		
		return joResponse;
		
	}
	
	@Transactional
	public DevtestResp delete(DevtestReq req) {
		DevtestResp joResponse = new DevtestResp();
		joResponse.status = "SUCCESS DELETE";
		
		if(req.id != null) {
			//DELETE
			Devtest devUpdate = devtestRepository.findById(req.id);
			devtestRepository.delete(devUpdate);
		} 
		
		return joResponse;
		
	}
	
	@Transactional
	public Object getDevtest(DevtestReq request) {
		DevtestResp response = new DevtestResp();
		response.status = "SUCCESS";
		
		List<Devtest> listDevtest = null; 
		Devtest devtest = null;
		
		JsonObject joObject = new JsonObject();
		
		if (request.name.isEmpty() && request.name.isEmpty()) {
			listDevtest = devtestRepository.findAll().list();
		} else if (!request.name.isEmpty() && !request.phone.isEmpty()){
			listDevtest = devtestRepository.findByNameAndPhone(request.name.trim().toLowerCase(), request.phone);
		} else if (!request.name.isEmpty() && request.phone.isEmpty()){
			listDevtest= devtestRepository.findByNameList(request.name.trim().toLowerCase());
		} else if (request.name.isEmpty() && !request.phone.isEmpty()){
			listDevtest= devtestRepository.findByPhone(request.phone);
		} else if (request.id != null && request.name.isEmpty() && request.phone.isEmpty()) {
			listDevtest = devtestRepository.findByIdList(request.id);
		}
		
		joObject.put("data", listDevtest);
		joObject.put("Email", "abc.gmail.com");
		joObject.put("alamat", "priuk");
		
//		response.data = joObject;
		
		return joObject;
		
	}
	
	@Transactional
	public DevtestResp getDevtestSatuan(DevtestReq request) {
		DevtestResp response = new DevtestResp();
		response.status = "SUCCESS";
		
		List<Devtest> listDevtest = null; 
		Devtest devtest = null;
		
		if (request.name != null && !request.name.isEmpty()) {
			devtest = devtestRepository.findByName(request.name);
		} else if (request.id != null) {
			devtest = devtestRepository.findById(request.id);
		}
		
		response.data = devtest;
		return response;
		
	}

}
