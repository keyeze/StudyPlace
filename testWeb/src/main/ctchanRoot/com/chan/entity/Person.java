package com.chan.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Person {
    private List<Person> children;
    private Person father;
    private Person mother;

    public List<Person> getChildren() {
        return children;
    }

    public Person setChildren(List<Person> children) {
        this.children = children;
        return this;
    }

    public Person getFather() {
        return father;
    }

    public Person setFather(Person father) {
        this.father = father;
        return this;
    }

    public Person getMother() {
        return mother;
    }

    public Person setMother(Person mother) {
        this.mother = mother;
        return this;
    }
}
