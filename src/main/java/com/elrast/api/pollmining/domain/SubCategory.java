package com.elrast.api.pollmining.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.DependsOn;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@DependsOn()
public class SubCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private long userId;
    private boolean visibility;
    private String name;

    @ManyToOne()
    @JsonIgnore
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
