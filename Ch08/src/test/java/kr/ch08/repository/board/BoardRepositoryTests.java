package kr.ch08.repository.board;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;
import kr.ch08.entity.board.ArticleEntity;
import kr.ch08.entity.board.CommentEntity;
import kr.ch08.entity.board.FileEntity;
import kr.ch08.entity.board.UserEntity;

@SpringBootTest
public class BoardRepositoryTests {
	
	@Autowired private ArticleRepository articleRepo;
	@Autowired private CommentRepository commentRepo;
	@Autowired private FileRepository fileRepo;
	@Autowired private UserRepository userRepo;
	
	@DisplayName("insertUser 테스트..")
	public void insertUser() {
		
		UserEntity user = UserEntity.builder()
									.uid("A103")
									.name("장보고")
									.hp("010-1234-2222")
									.build();
		userRepo.save(user);
	}
	
	@DisplayName("insertArticle 테스트..")
	public void insertArticle() {
		
		UserEntity user = UserEntity.builder().uid("A103").build(); // 참조
		
		ArticleEntity article = ArticleEntity.builder()
											 .title("제목4")
											 .content("내용4")
											 .user(user)
											 .build();
		articleRepo.save(article);
	}
	
	
	@DisplayName("insertComment 테스트..")
	public void insertComment() {
		
		UserEntity user = UserEntity.builder().uid("A101").build(); // 참조
		ArticleEntity article = ArticleEntity.builder().no(1).build();
		
		CommentEntity comment = CommentEntity.builder()
											 .content("댓글1")
											 .user(user)
											 .article(article)
											 .build();
		commentRepo.save(comment);
	}
	
	@DisplayName("insertFile 테스트..")
	public void insertFile() {
		
		ArticleEntity article = ArticleEntity.builder().no(1).build(); // 참조
		
		FileEntity file = FileEntity.builder()
									.oName("파일1.txt")
									.sName("AdfsSdwexxx.txt")
									.article(article)
									.build();
		fileRepo.save(file);
	}
	
	@DisplayName("selectArticles 테스트..")
	public void selectArticles() {
		
		List<ArticleEntity> articles = articleRepo.findAll();
		System.out.println(articles);
		
		for(ArticleEntity article : articles)
		{
			System.out.println(article);
		}
	}
	
	@Test
	@Transactional
	/*
	 * 양방향으로 처리되는 엔티티 관계에서 SELECT를 두번 처리하기 때문에
	 * 첫번째 SELECT를 처리하고 데이터베이스와 세션이 끝나므로
	 * 두번째 SELECT를 실행할 때는 no session 에러가 발생
	 * 이럴경우 @Transactional 선언으로 트랜잭션 처리를 해줘야 됨 
	 */
	@DisplayName("selectArticle 테스트..")
	public void selectArticle() {
		
		Optional<ArticleEntity> result = articleRepo.findById(5);
		ArticleEntity article = result.orElseThrow();
		
		System.out.println(article);
	}
}
