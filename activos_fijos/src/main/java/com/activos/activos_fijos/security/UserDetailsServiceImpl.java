package com.activos.activos_fijos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.activos.activos_fijos.entities.Usuario;
import com.activos.activos_fijos.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = userRepository.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("Username: " + username + " not found");
		return new User(user.getUsername(), user.getPassword(), AuthorityUtils
			                	.commaSeparatedStringToAuthorityList("ROLE_" + user.getRoles()));
	}
}
