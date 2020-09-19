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

    @Column
    public Integer rank;

    Foo() {
        // for simpler reflective construction
    }

    public Foo(String name, Integer rank) {
        this.name = name;
        this.rank = rank;
    }

}
