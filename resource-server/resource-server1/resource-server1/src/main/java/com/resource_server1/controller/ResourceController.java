package com.resource_server1.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
	
//	@Autowired
//	private Principal principal;
	
	
	@GetMapping("/getData")
	public Map<String, Object> getData(){
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		//Principal principal = (Principal)authentication.getPrincipal();
		//UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		Map<String, Object> data = new HashMap<>();
		data.put("name", "Ranjay");
		data.put("laptop", "hp");
		data.put("principal_username", authentication.getName());
		//data.put("principal_password", userDetails.getPassword());
		//data.put("principal_password", userDetails.getAuthorities());
		data.put("is_authenticated", authentication.isAuthenticated());
		return data;
	}

}
