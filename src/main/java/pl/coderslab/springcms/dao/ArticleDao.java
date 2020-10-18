package pl.coderslab.springcms.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.springcms.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
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

    public List<Article> fillAllArticles(){
        Query query = entityManager.createQuery("SELECT b FROM Article b");
        return query.getResultList();
    }

    public List<Article> last5AddedArticles(){
        Query query = entityManager.createQuery("SELECT b FROM Article b ORDER BY b.created DESC");
        query.setMaxResults(5);

        return query.getResultList();
    }


}
