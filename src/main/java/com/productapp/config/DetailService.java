package com.productapp.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.productapp.model.entities.AppUser;
import com.productapp.model.repo.AppUserRepository;

@Service
public class DetailService implements UserDetailsService {

	@Autowired
	private AppUserRepository appUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AppUser user=appUserRepository.findByuserEmail(email);
		if(user==null) {
			throw new UsernameNotFoundException("user is not found");
		}else {
		return new User
				(user.getUserEmail(),user.getUserPassword(),
						AuthorityUtils.createAuthorityList(user.getRoles()));
				
		}
	}
}
			
	


