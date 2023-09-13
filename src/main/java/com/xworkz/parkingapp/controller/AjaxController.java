package com.xworkz.parkingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.xworkz.parkingapp.entity.ParkingInfoEntity;
import com.xworkz.parkingapp.service.ParkingInfoService;

@EnableWebMvc
@RestController
@RequestMapping("/")
public class AjaxController {

	@Autowired
	ParkingInfoService service;

	public AjaxController() {
		System.out.println("running ajax controller");

	}

	@GetMapping(value = "/userAjax/{location}/{vtype}/{vclassification}/{term}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ParkingInfoEntity userAjax(@PathVariable String location, @PathVariable String vtype,
			@PathVariable String vclassification, @PathVariable String term) {
		System.out.println("entity"+location+" "+vtype+" "+vclassification+" "+term);
		ParkingInfoEntity dto = this.service.findByAll(location, vtype, vclassification, term);
				return dto;
		
		/*
		 * ParkingInfoDTO entity = this.service.findByAll(location, vtype,
		 * vclassification, term); System.out.println("entity : "+entity);
		 * System.out.println(entity); if (entity != null) {
		 * System.out.println("fields are not exists "); } else {
		 * System.out.println("all fields are already exists"); } return "data";
		 */

	}

//	@GetMapping(value = "/name")
//	public String ajax() {
//		return "nsvdghjasdfs";
//	}

}
