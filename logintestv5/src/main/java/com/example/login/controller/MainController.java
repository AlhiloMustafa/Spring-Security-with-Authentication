package com.example.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.login.entity.User;
import com.example.login.repository.UserRepository;

@Controller
public class MainController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(value = "")
	public String dashboardPage() {

		return "home";

	}

	@GetMapping(value = "/userregister")
	public String register(Model model) {
		model.addAttribute("user", new User());

		return "userregister";

	}

	@PostMapping("/post_register")
	public String postRegisteration(User user) {

		BCryptPasswordEncoder myencoder = new BCryptPasswordEncoder();
		String Passwordencoded = myencoder.encode(user.getPassword());
		user.setPassword(Passwordencoded);
		userRepository.save(user);
		return "success_page";

	}

	@GetMapping(value = "/login")
	public String getlogin() {

		return "login";
	}

	@PostMapping("/post_login")
	public String postLogin(@RequestParam("email") String logEmail, @RequestParam("password") String logPassword,
			Model themodel) {

		System.out.println("enterd email :" + logEmail);
		System.out.println("entered pass: " + logPassword);

		return "success_page";
	}

	@GetMapping("/my_users")
	public String viewUsersLiString(Model themodel) {

		List<User> listOfUsers = userRepository.findAll();

		themodel.addAttribute("listOfUsers", listOfUsers);

		return "users";

	}

}
