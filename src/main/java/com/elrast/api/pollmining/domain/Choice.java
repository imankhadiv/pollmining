package com.elrast.api.pollmining.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Choice {

    @Id
    @GeneratedValue
    private long id;
    private long count;

    @ManyToOne
    private Question question;
    @Size(min = 1, max = 100)
    String optionDescription;

    public Choice(@Size(min = 1, max = 100) String optionDescription) {
        this.optionDescription = optionDescription;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}