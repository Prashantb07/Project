package com.xworkz.parkingapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.parkingapp.dto.ParkingDTO;
import com.xworkz.parkingapp.service.ParkingService;

@RequestMapping("/")
@Controller
public class ParkingController {
	@Autowired
	ParkingService service;

	public ParkingController() {

		System.out.println("inside the method");

	}

	@PostMapping("/admin")
	public String onHome(ParkingDTO dto,String email, String password, Model model,HttpServletRequest req) {
		System.out.println(email);
		System.out.println("this is inside onHome method");

		ParkingDTO dto2 = service.userSignIn(email, password);
		if (dto2 != null) {
			System.out.println(dto2);
			HttpSession session = req.getSession(true);
			session.setAttribute("dto",dto2);
			/*
			 * model.addAttribute("name", dto2.getAdminName()); model.addAttribute("time",
			 * dto2.getLoginTime()); model.addAttribute("email", dto2.getEmail());
			 */
			return "/parkinginfo.jsp";

		}
			return "/sign.jsp";
	}
}
