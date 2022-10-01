package com.raouf.demo.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.raouf.demo.ConflicException;
@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	@Bean
	private PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return new User("raouf", passwordEncoder().encode("azerty"), AuthorityUtils.NO_AUTHORITIES);
	}
	public AppUser addUser(AppUser appuser) {
		
		/*if(userRepository.findByUsername(appuser.getUsername())!=null) {
			throw new ConflicException("cet email esiste");
		}*/
		appuser.setPassword(passwordEncoder().encode(appuser.getPassword()));
		this.userRepository.save(appuser);
		return appuser;
	}
	public List<AppUser> findAll(){
		return this.userRepository.findAll();
	}
	

}
