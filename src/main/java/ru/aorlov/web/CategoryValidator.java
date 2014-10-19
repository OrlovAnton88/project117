package ru.aorlov.web;

import org.springframework.validation.Errors;

import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.aorlov.model.studymaterial.Category;

/**
 * Created by anton on 20.10.14.
 */
public class CategoryValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Category.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "categoryId", "categoryId.empty");

        Category category = (Category) obj;
        if (category.getCategoryId() < 0) {
            errors.rejectValue("categoryId", "negativevalue");
        }

    }
}
