package com.custome_page;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.custome_page.bean.User;
import com.custome_page.repo.Repo;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private Repo repo;

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String login() {
		System.out.println("Hwllo");

		return "LoginPage";
	}

	

	
	  @RequestMapping(value = "/registered",method = RequestMethod.POST) public String
	  logined1(@ModelAttribute User user){
	  
		  user.setPassword(passwordEncoder.encode(user.getPassword()));
		  user.setRole("ROLE_NORMAL");
	  repo.save(user); return "LoginPage"; }
	  
	  @RequestMapping(value = "/afterlogin", method = RequestMethod.GET)
		public String logi() {

			System.out.println("hellllllllllllll");
			return "AfterLogin";
		}


}
