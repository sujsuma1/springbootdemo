package com.ibm.touchlessFG.demo.ServiceImpl;

import static java.util.UUID.fromString;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ibm.touchlessFG.demo.Dao.UserDao;
import com.ibm.touchlessFG.demo.Model.Users;
import com.ibm.touchlessFG.demo.Repository.UserRepository;


@Service
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;
	private final UserDao userDao;

	public UserService(final UserRepository userRepository, final UserDao userDao) {
		this.userRepository = userRepository;
		this.userDao = userDao;
	}

	public List<Users> getUsers(final String userId) {

		final List<Users> users;

		if (StringUtils.isEmpty(userId)) {
			users = userRepository.findAll();
		} else {
			users = userRepository.findByUserId(fromString(userId));
		}

		return users;
	}

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Users user = userDao.findOneByName(userId);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(),
				"$2a$10$CELb2i4E3Vjv/e2jME0jcuUBZNf92ir1eRlYNk6kIQftEbJBGSC7i", getAuthority());
	}

	private List getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	public Users findOneByName(String userId) {
		return userDao.findOneByName(userId);
		
	}
}
