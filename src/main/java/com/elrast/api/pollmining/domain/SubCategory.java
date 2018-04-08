package com.elrast.api.pollmining.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private long userId;
    private boolean visibility;
    private String name;

    @ManyToOne()
    private Category category;

    public SubCategory(long userId, @NotNull String name, Category category) {
        this.userId = userId;
        this.name = name;
        this.category = category;
    }

    public SubCategory() {
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}
