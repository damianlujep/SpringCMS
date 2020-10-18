package pl.coderslab.springcms.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.springcms.entity.Author;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Repository
@Transactional
public class AuthorDao {
    EntityManager entityManager;

    public void saveAuthor(Author author){
        entityManager.persist(author);
    }

    public Author findById(long id){
        return entityManager.find(Author.class, id);
    }

    public void update(Author author){
        entityManager.merge(author);
    }

    public void delete(Author author) {
        entityManager.remove(entityManager.contains(author) ?
                author : entityManager.merge(author));
    }
}
