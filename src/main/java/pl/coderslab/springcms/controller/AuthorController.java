package pl.coderslab.springcms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springcms.dao.AuthorDao;
import pl.coderslab.springcms.entity.Author;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private final AuthorDao authorDao;

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
    public String saveAuthorFromForm(@ModelAttribute("author") @Valid Author author, BindingResult result, Model m){
        if (result.hasErrors()){
            m.addAttribute("author", author);
            return "add-author-form";
        }

        authorDao.saveAuthor(author);
        return "redirect: showAll";
    }

    @GetMapping("delete/{id}")
    public String deleteAuthor(@PathVariable long id){
        Author byId = this.authorDao.findById(id);
        this.authorDao.delete(byId);

        return "redirect: ../showAll";
    }

    @GetMapping("/edit/{id}")
    public String editAuthorForm(@PathVariable long id, Model m){
        Author authorToEdit = authorDao.findById(id);
        m.addAttribute("authorToEdit", authorToEdit);
        m.addAttribute("author", new Author());
        return "edit-author-form";
    }

    @PostMapping("/savechanges")
    public String editFormProcess (@ModelAttribute Author author){
        authorDao.update(author);

        return "redirect: showAll";
    }
}
