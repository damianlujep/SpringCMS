package pl.coderslab.springcms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springcms.dao.AuthorDao;
import pl.coderslab.springcms.entity.Author;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {
    final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("showAll")
    public String showAllAuthors(Model m){
        List<Author> allAuthors = authorDao.findAllAuthors();
        m.addAttribute("authorsList", allAuthors);
        return "list-authors";
    }

    @GetMapping("/addForm")
    public String addAuthorForm(Model m){
        m.addAttribute("author", new Author());

        return "add-author-form";
    }

    @PostMapping("/addForm")
    public String saveAuthorFromForm(@ModelAttribute Author author){
        authorDao.saveAuthor(author);

        return "redirect: showAll";
    }
}
