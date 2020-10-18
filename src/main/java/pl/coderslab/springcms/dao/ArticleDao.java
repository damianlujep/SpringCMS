package pl.coderslab.springcms.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.springcms.entity.Article;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Repository
@Transactional
public class ArticleDao {
    EntityManager entityManager;

    public void saveArticle(Article article){
        entityManager.persist(article);
    }

    public Article findById(long id){
        return entityManager.find(Article.class, id);
    }

    public void update(Article article){
        entityManager.merge(article);
    }

    public void delete(Article article) {
        entityManager.remove(entityManager.contains(article) ?
                article : entityManager.merge(article));
    }
}
