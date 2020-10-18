package pl.coderslab.springcms.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.springcms.entity.Category;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Repository
@Transactional
public class CategoryDao {
    EntityManager entityManager;

    public void saveCategory(Category category){
        entityManager.persist(category);
    }

    public Category findById(long id){
        return entityManager.find(Category.class, id);
    }

    public void update(Category category){
        entityManager.merge(category);
    }

    public void delete(Category category) {
        entityManager.remove(entityManager.contains(category) ?
                category : entityManager.merge(category));
    }
}
