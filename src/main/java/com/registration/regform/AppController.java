package com.registration.regform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
	
	@Autowired
	private UserRepository repo;
	@GetMapping("")
	public String viewHomePage() {
	
		return "index";
}

	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	@Autowired
	private EmailSenderService senderService;
	@PostMapping("/process_register")
	public String processRegistration(User user) {
		
		repo.save(user);
		
		return "register_success";	
	}
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
	
		senderService.sendEmail("nandaprabhat3@gmail.com","Successful Registration",
				"Congrats! You have successfully registered");
	}
		
	
}
	
	
