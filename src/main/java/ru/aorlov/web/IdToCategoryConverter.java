package ru.aorlov.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import ru.aorlov.model.studymaterial.Category;
import ru.aorlov.service.studymaterial.CategoryService;

/**
 * Created by anton on 20.10.14.
 */

/**
 * Converter for Study materials section
 */
public class IdToCategoryConverter implements Converter<String, Category> {

    @Autowired
    CategoryService categoryService;

    @Override
    public Category convert(String id) {
        return this.categoryService.findOne(Long.valueOf(id));
    }
}
