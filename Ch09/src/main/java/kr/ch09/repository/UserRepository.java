package kr.ch09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ch09.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
	
	// Id, PW를 조회하는 쿼리메서드
	public UserEntity findUserEntityByUidAndPass(String uid, String pass);
}
