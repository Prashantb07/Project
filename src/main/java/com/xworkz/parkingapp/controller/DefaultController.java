package com.xworkz.parkingapp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.parkingapp.dto.ParkingDTO;

import lombok.extern.slf4j.Slf4j;

public class DefaultController {
	
	public DefaultController() {
		System.out.println("inside default controller");
	}
	@RequestMapping("/start")
	public String onStart(Model model) {
		System.out.println("onstart method started in default controller");
		model.addAttribute("dto",new ParkingDTO());
		System.out.println("after model attribute");
		return "/home.jsp";
	}
	

}
