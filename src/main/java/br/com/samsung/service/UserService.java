package br.com.samsung.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.samsung.data.model.Permission;
import br.com.samsung.data.model.User;

@Service
public class UserService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = new User();
		user.setId(1L);
		user.setAccountNonExpired(false);
		user.setAccountNonLocked(false);
		user.setCredentialsNonExpired(false);
		user.setFullname("Admin");
		user.setUsername(username);
		user.setPassword("admin123");

		Permission permission = new Permission();
		permission.setId(1L);
		permission.setDescription("ADMIN");

		Set<Permission> permissions = new HashSet<Permission>();

		user.setPermissions(permissions);

		return user;
	}
}
