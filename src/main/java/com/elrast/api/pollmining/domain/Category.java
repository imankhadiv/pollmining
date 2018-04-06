package com.elrast.api.pollmining.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private long userId;


    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "category")
    @OneToMany
    private Set<SubCategory> subCategories;

    public Category(String name, long userId) {
        this.name = name;
        this.userId = userId;
    }

    public Category() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getUserId() {
        return userId;
    }
}
