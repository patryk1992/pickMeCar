package com.mgr.pickMeCar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mgr.pickMeCar.Details.CustomUserDetails;
import com.mgr.pickMeCar.db.model.User;
import com.mgr.pickMeCar.db.repository.UserRepository;
import com.mgr.pickMeCar.db.repository.UserRolesRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	private final UserRolesRepository userRolesRepository;
	
	@Autowired
    public CustomUserDetailsService(UserRepository userRepository,UserRolesRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository=userRolesRepository;
    }
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user=userRepository.findOneByUserName(userName);
		  if(null == user){
		   throw new UsernameNotFoundException("No user present with username: "+userName);
		  }else{
		   List<String> userRoles=userRolesRepository.findRoleByName(userName);
		   return new CustomUserDetails(user,userRoles);
		  }
	}

}
