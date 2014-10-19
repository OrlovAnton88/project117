package ru.aorlov.web;

import ru.aorlov.model.studymaterial.Category;
import ru.aorlov.service.studymaterial.CategoryService;

import java.beans.PropertyEditorSupport;

/**
 * Created by anton on 20.10.14.
 */
public class CategoryEditor extends PropertyEditorSupport {

    private CategoryService categoryService;

    public CategoryEditor(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Category category = categoryService.findOne(Long.parseLong(text));
        setValue(category);
    }


}