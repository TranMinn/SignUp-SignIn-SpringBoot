package io.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String viewHomepage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		model.addAttribute("user", new User());
		return "register_form";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepository.save(user);
		return "register_success";
		
	}
	
	@GetMapping("/users_list")
	public String listUsers(Model model) {
		List<User> listUsers = userRepository.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}
}
