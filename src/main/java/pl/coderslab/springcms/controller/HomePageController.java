package pl.coderslab.springcms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.springcms.dao.ArticleDao;
import pl.coderslab.springcms.entity.Article;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class HomePageController {

    private final ArticleDao articleDao;

    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping("/")
    @ResponseBody
    public String home(){
        StringBuilder body= new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        List<Article> articles = articleDao.last5AddedArticles();
        for(Article a : articles){
            body.append("<b>Title: </b>").append(a.getTitle()).append("  ")
                    .append("<b>Created on: </b>").append(a.getCreated().format(formatter)).append("  ")
                    .append("<b>Content: </b>").append(a.getContent()).append("<br/>");
        }

        return body.toString();
    }
}
