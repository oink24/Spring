package kr.co.sboard.dto;

import kr.co.sboard.entity.ArticleEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ArticleDTO {

    private String title;
    private String content;
    private String writer;
    private String regip;

    public ArticleEntity toEntity() {
        return ArticleEntity.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .regip(regip)
                .build();
    }
}
