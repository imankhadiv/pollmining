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

    @ManyToOne
    private Category category;

    public SubCategory(long id, long userId, @NotNull String name) {
        this.id = id;
        this.userId = userId;
        this.name = name;
    }

    public SubCategory() {
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }
}
