package br.com.devDojo.awesome.model;

import jakarta.persistence.Entity;

@Entity
public class Student extends AbstractEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
