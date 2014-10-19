package ru.aorlov.service.studymaterial;

import org.springframework.stereotype.Service;
import ru.aorlov.model.studymaterial.Category;
import ru.aorlov.repository.studymaterial.CategoryRepository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by anton on 20.10.14.
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


    @Override
    public Category findOne(Long id) {
        return categoryRepository.findOne(id);
    }
}
