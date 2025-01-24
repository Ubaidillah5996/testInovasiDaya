package com.muhammadubaidillah.devtest.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.JsonString;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.security.SecuritySchemes;

import com.muhammadubaidillah.devtest.dto.InovasiReq;
import com.muhammadubaidillah.devtest.dto.InovasiResp;
import com.muhammadubaidillah.devtest.service.InovasiDayaTestService;

import oracle.jdbc.driver.JsonWebToken;

@Path("/v1/inovasi")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({"User"})
@RequestScoped

public class InovasiDayaTestController {
	
	@Inject
	InovasiDayaTestService inovasiDayaTestService;
	
	@Path("/save")
    @POST
    public Response SaveInovasi(List<InovasiReq> request) throws Exception {
        return inovasiDayaTestService.saveInovasi(request);
    }
	
	@Path("/get")
    @GET
    public InovasiResp getAll() throws Exception {
        return inovasiDayaTestService.getAll();
    }
	
}
