package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.repository.employeeRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private employeeRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Employee emp=repo.findByEmail(username);
		if(emp==null) {
			throw new UsernameNotFoundException("Username Not Found");
		}
		else {
			return new CustomUser(emp);
		}
		
	}

}
