package com.xworkz.parkingapp.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/")
@Controller
public class UserParkingController {
	
	/*@Autowired
	private UserParkingService service;
	
	public UserParkingController() {
		System.out.println("created"+this.getClass().getSimpleName());
	}
//	@PostMapping("/userSave")
	public String userParkSave(@Valid UserParkingDTO dto,BindingResult bindingResult ,Model model) {
		System.out.println("running userParkSave");
		
		if(bindingResult.hasFieldErrors()) {
		model.addAttribute("errors",bindingResult.getAllErrors());
		model.addAttribute("dto",dto);
		return "/userinfo.jsp";
	}
	else {
		System.out.println("data is valid");
		service.validateAndSave(dto);
		model.addAttribute("msg","userinfo saved successfully");
	}
		return "/responseuser.jsp";
	}

}
*/
}