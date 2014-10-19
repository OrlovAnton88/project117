package ru.aorlov.service.studymaterial;

import ru.aorlov.model.studymaterial.Category;

import java.util.List;

/**
 * Created by anton on 18.10.14.
 */

public interface CategoryService {

    public List<Category> findAll();


    public Category findOne(Long id);
}
