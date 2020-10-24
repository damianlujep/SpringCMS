package pl.coderslab.springcms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springcms.dao.ArticleDao;
import pl.coderslab.springcms.dao.CategoryDao;
import pl.coderslab.springcms.entity.Category;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryDao categoryDao;
    private final ArticleDao articleDao;

    public CategoryController(CategoryDao categoryDao, ArticleDao articleDao) {
        this.categoryDao = categoryDao;
        this.articleDao = articleDao;
    }

    @GetMapping("/showAll")
    public String showAllCategories(Model m){
        List<Category> allCategories = categoryDao.findAllCategories();

        m.addAttribute("categoriesList", allCategories);

        return "list-categories";
    }

    @GetMapping("/addForm")
    public String showCategoryForm (Model m){
        m.addAttribute("category", new Category());

        return "add-category-form";
    }

    @PostMapping("/addForm")
    public String processForm(@ModelAttribute("category") @Valid Category category, BindingResult result, Model m){
        if (result.hasErrors()){
            return "add-category-form";
        }

        this.categoryDao.saveCategory(category);
        return "redirect: showAll";
    }

    @GetMapping("delete/{id}")
    public String deleteCategory(@PathVariable long id){
        Category byId = this.categoryDao.findById(id);
        this.categoryDao.delete(byId);

        return "redirect: ../showAll";
//        return "<h3> The Category of id= " + id + " have been erased.</h3>";
    }

    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable long id, Model m){
        Category categoryToEdit = categoryDao.findById(id);
        m.addAttribute("categoryToEdit", categoryToEdit);
        m.addAttribute("category", new Category());
        return "edit-category-form";
    }

    @PostMapping("/savechanges")
    public String editFormProcess (@ModelAttribute Category category){
        categoryDao.update(category);

        return "redirect: showAll";
    }
}
