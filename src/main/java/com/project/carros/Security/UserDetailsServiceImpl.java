package com.project.carros.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.carros.Model.User;
import com.project.carros.Repository.UserRepository;

@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 
		 User user = userRepo.findByLogin(username);
		 
		 if(user == null) {
			throw new UsernameNotFoundException("Usuario não encontrado");
		 }
		 return org.springframework.security.core.userdetails.User.withUsername(username).password(user.getSenha()).roles("USER").build();
 	}
   
}
