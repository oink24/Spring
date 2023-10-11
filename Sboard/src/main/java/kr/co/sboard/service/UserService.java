package kr.co.sboard.service;

import kr.co.sboard.dto.UserDTO;
import kr.co.sboard.entity.TermsEntity;
import kr.co.sboard.entity.UserEntity;
import kr.co.sboard.repository.TermsRepository;
import kr.co.sboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private TermsRepository termsRepository;

    @Autowired
    private UserRepository userRepository;

    public TermsEntity findByTerms() {
        return termsRepository.findById(1).get();
    }

    public void save(UserDTO dto) {
        UserEntity entity = dto.toEntity(); // DTO를 Entity로 반환
        userRepository.save(entity); // DB INSERT
    }
}
