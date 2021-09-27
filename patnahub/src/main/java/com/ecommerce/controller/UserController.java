package com.ecommerce.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;


import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;

@Controller
public class UserController {
	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(value = "/userhome")
	public String userHome(Model model, HttpSession session) {
		model.addAttribute("pageinfo", "product catalog");
		List<Product> productList = productRepository.findAll();
		model.addAttribute("productlist", productList);
		return "userhome";
	}
	@RequestMapping(value = "/login-page")
	public String loginUser(Model model, HttpSession session) {
		String page="";
		boolean loggedIn=false;
		SecurityContext context=SecurityContextHolder.getContext();
		Authentication authentication=context.getAuthentication();
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		String username=authentication.getName();
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role",role.getAuthority() );
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				loggedIn=true;
				page="admin_page";
				session.setAttribute("loggedin", loggedIn);
				session.setAttribute("username", username);
			}
			else
			{
				model.addAttribute("pageinfo", "user home");
				List<Product> productList = productRepository.findAll();
				model.addAttribute("productlist", productList);
				loggedIn=true;
				page="username";
				session.setAttribute("loggedin", loggedIn);
				session.setAttribute("username", username);
			}
		}
		
		return page;
	}
}
