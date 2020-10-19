package pl.coderslab.springcms.controller;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springcms.dao.ArticleDao;
import pl.coderslab.springcms.dao.AuthorDao;
import pl.coderslab.springcms.dao.CategoryDao;
import pl.coderslab.springcms.entity.Article;
import pl.coderslab.springcms.entity.Author;
import pl.coderslab.springcms.entity.Category;

import javax.transaction.Transactional;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    @Autowired
    public ArticleController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping("/showAll")
    @Transactional
    public String showAllArticles(Model m){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");

        List<Article> articleList = articleDao.fillAllArticles();

        for (Article b: articleList){
            Hibernate.initialize(b.getCategories());
        }

        m.addAttribute("articleList", articleList);
        m.addAttribute("formatter",formatter);

        return "list-articles";
    }

    @GetMapping("/addForm")
    public String addCategoryForm (Model m){
        m.addAttribute("article", new Article());

        return "add-article-form";
    }

    @PostMapping("/addForm")
    public String processForm(@ModelAttribute Article article){
        this.articleDao.saveArticle(article);
        return "redirect: showAll";
    }

    @GetMapping("delete/{id}")
    public String deleteArticle(@PathVariable long id){
        Article byId = this.articleDao.findById(id);
        this.articleDao.delete(byId);

        return "redirect: ../showAll";
    }

    @GetMapping("/edit/{id}")
    public String editArticleForm(@PathVariable long id, Model m){
        Article articleToEdit = articleDao.findById(id);
        m.addAttribute("articleToEdit", articleToEdit);
        m.addAttribute("article", new Article());
        return "edit-article-form";
    }

    @PostMapping("/savechanges")
    public String editFormProcess (@ModelAttribute Article article){
        articleDao.update(article);

        return "redirect: showAll";
    }

    @ModelAttribute("authorsList")
    public List<Author> authors(){
        return authorDao.findAllAuthors();
    }

    @ModelAttribute("categoriesList")
    public List<Category> categories(){
        return this.categoryDao.findAllCategories();
    }
}
