package kr.ch10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ch10.entity.User1Entity;
import kr.ch10.repository.User1Repository;

@Service
public class User1Service {
	
	@Autowired
	private User1Repository repo;
	
	public int insertUser1(User1Entity user1) {
		// repo.save(user1);
		// 해당 user id가 존재할 경우를 위한 세분화
		if(!repo.existsById(user1.getId())) {
			repo.save(user1);
			return 0;
		} else {
			return 1;
		}
	}
	public User1Entity selectUser1(String id) {
		// return repo.findById(id).get();
		// 해당 user id가 존재하지 않을 경우를 위한 세분화
		if(repo.existsById(id))
			return repo.findById(id).get();
		else
			return null;
	}
	public List<User1Entity> selectUser1s() {
		return repo.findAll();
	}
	public int updateUser1(User1Entity user1) {
		// repo.save(user1);
		// 해당 user id가 존재하지 않을 경우를 위한 세분화
		if(repo.existsById(user1.getId())) {
			repo.save(user1);
			return 0;
		} else {
			return 1;
		}
    }
	public int deleteUser1(String id) {
		// repo.deleteById(id);
		// 해당 user id가 존재하지 않을 경우를 위한 세분화
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return 0;
		}
		else {
			return 1;
		}
    }
}
