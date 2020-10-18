package pl.coderslab.springcms.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.springcms.dao.CategoryDao;
import pl.coderslab.springcms.entity.Category;

public class CategoryConverter implements Converter<String, Category> {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category convert(String s) {
        return categoryDao.findById(Integer.parseInt(s));
    }
}
