package com.example.h2functiontest.entity;

import javax.persistence.*;

@Entity
@Table(schema = "theschema", name = "foo")
public class Foo {

    @Id
    @GeneratedValue
    public Integer id;

    @Column
    public String name;

    Foo() {
        // for simpler reflective construction
    }
    public Foo(String name) {
        this.name = name;
    }

}
