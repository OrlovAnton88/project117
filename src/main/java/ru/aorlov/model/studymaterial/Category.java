package ru.aorlov.model.studymaterial;

import org.jetbrains.annotations.Nullable;

import javax.persistence.*;


import org.jetbrains.annotations.NotNull;

/**
 * Created by anton on 18.10.14.
 */

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long categoryId;

    @NotNull
    private String name;

    @Column
    @Nullable
    private String description;

    @NotNull
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(@NotNull Long categoryId) {
        this.categoryId = categoryId;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }
}
