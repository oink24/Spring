package kr.co.sboard.controller.article;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sboard.entity.ArticleEntity;
import kr.co.sboard.service.ArticleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/list")
    public String list() {
        return "/article/list";
    }

    @GetMapping("/article/register")
    public String register() {
        return "/article/register";
    }
    @PostMapping("/article/register")
    public String register(HttpServletRequest request, ArticleEntity entity) {

        entity.setRegip(request.getRemoteAddr());
        log.info(entity);

        articleService.save(entity);
        return "redirect:/article/list";
    }
}
