package pl.coderslab.springcms.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100)
    @NotBlank @Size(min = 5)
    private String name;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private List<Article> articles = new ArrayList<>();

    public Category() {
    }

    public List<Article> getArticles() {
        return articles;
    }

    public Category setArticles(List<Article> article) {
        this.articles = article;
        return this;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
