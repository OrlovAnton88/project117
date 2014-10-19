package ru.aorlov.model.studymaterial;

import javax.persistence.*;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

/**
 * Created by anton on 18.10.14.
 */
@Entity
@Table(name = "MATERIAL")
public class Material {

    public Material() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull
    public Long meterialId;

    @Column
    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @javax.validation.constraints.NotNull
    private Category category;

    @NotNull
    @Column
    private String htmlText;

    @NotNull
    @Column
    private Date modificationTime;

    @NotNull
    @Column
    private Date creationTime;

    @NotNull
    public Long getMeterialId() {
        return meterialId;
    }

    public void setMeterialId(@NotNull Long meterialId) {
        this.meterialId = meterialId;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(@NotNull Category category) {
        this.category = category;
    }

    @NotNull
    public String getHtmlText() {
        return htmlText;
    }

    public void setHtmlText(@NotNull String htmlText) {
        this.htmlText = htmlText;
    }

    @NotNull
    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(@NotNull Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    @NotNull
    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(@NotNull Date creationTime) {
        this.creationTime = creationTime;
    }

    public void update(String name, Category category, String htmlText) {
        this.name = name;
        this.category = category;
        this.htmlText = htmlText;
    }


    @PrePersist
    public void prePersist() {
        Date now = new Date();
        creationTime = now;
        modificationTime = now;
    }

    @PreUpdate
    public void preUpdate() {
        modificationTime = new Date();
    }

    public static Builder getBuilder(String name, Category category, String htmlText) {
        return new Builder(name, category, htmlText);
    }

    /**
     * A Builder class used to create new Person objects.
     */
    public static class Builder {
        Material built;

        Builder(String name, Category category, String htmlText) {
            built = new Material();
            built.name = name;
            built.category = category;
            built.htmlText = htmlText;
        }

        public Material build() {
            return built;
        }

    }

}
