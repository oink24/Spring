package kr.ch09.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.ch09.entity.UserEntity;
import kr.ch09.repository.UserRepository;

@Service
public class SecurityUserService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user = repo.findById(username).get();
		UserDetails userDetails = MyUserDetails.builder()
												.uid(user.getUid())
												.pass(user.getPass())
												.name(user.getName())
												.age(user.getAge())
												.hp(user.getHp())
												.role(user.getRole())
												.regDate(user.getRegDate())
												.build();
		
		return userDetails;
	}
}
