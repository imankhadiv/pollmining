package com.elrast.api.pollmining.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Queue;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private long userId;

    @Column(columnDefinition = "boolean default false")
    private boolean visibility;

    @Column(columnDefinition = "boolean default false")
    private boolean locked;

    private long dislike;

    @ManyToOne
    @JsonIgnore
    private SubCategory subCategory;

    @NotNull
    @Size(max = 100, min = 1)
    private String topic;

    public Question(){};

    public Question(@NotNull @Size(max = 100, min = 1) String topic) {
        this.topic = topic;
    }
}
