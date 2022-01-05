package com.thbs.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.thbs.constantProperties.Constants;
import com.thbs.models.User;
import com.thbs.models.house;
import com.thbs.repo.UserRepository;
import com.thbs.services.houseServices;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepository;

	@Autowired
	houseServices houseService;
	@PostMapping(value = Constants.USER_RGISTERATION)
	public String registerUser(@ModelAttribute("user") User user) {
		// TODO Auto-generated method stub
		Optional<User> searchUser = userRepository.findById(user.getUsername());
		if (searchUser.isPresent()) {
			User userFound = searchUser.get();
			return "sameusername";

		} else {
			userRepository.save(user);
			return "index";
		}
	}

	@PostMapping(value = Constants.USER_LOGIN_VALIDATION)
	public String loginUser(@ModelAttribute("user") User u, Model model) {
		Optional<User> searchUser = userRepository.findById(u.getUsername());
		if (searchUser.isPresent()) {
			User userFromDb = searchUser.get();
			if (u.getPassword().equals(userFromDb.getPassword())) {
				List<house> listProducts = houseService.getAllEmployees();
				model.addAttribute("listProducts", listProducts);
				return "userindex";
			} else {
				return "invalid";
			}

		} else
			return "invalid";
	}

}
