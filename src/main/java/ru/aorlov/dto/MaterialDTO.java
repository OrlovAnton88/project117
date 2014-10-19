package ru.aorlov.dto;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;
import ru.aorlov.model.studymaterial.Category;

/**
 * Created by anton on 18.10.14.
 */
public class MaterialDTO {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private Category category;

    @NotEmpty
    private String htmlText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getHtmlText() {
        return htmlText;
    }

    public void setHtmlText(String htmlText) {
        this.htmlText = htmlText;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
