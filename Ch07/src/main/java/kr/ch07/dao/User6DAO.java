package kr.ch07.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ch07.dto.User6DTO;

@Repository
public class User6DAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertUser6(User6DTO dto) {
		mybatis.insert("user6.insertUser6", dto);
	}
	public User6DTO selectUser6(String uid) {
		return mybatis.selectOne("user6.selectUser6", uid);
	}
	public List<User6DTO> selectUser6s() {
		return mybatis.selectList("user6.selectUser6s");
	}
	public void updateUser6(User6DTO dto) {
		mybatis.update("user6.updateUser6", dto);
	}
	public void deleteUser6(String uid) {
		mybatis.delete("user6.deleteUser6", uid);
	}
}
