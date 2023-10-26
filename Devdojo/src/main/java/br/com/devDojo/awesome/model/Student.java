package br.com.devDojo.awesome.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class Student {
    private int id;
    private String name;
    public static List<Student> studentList;

    static {
        studentRepository();
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }
    public Student() {

    }

    private static void studentRepository(){
        studentList = new ArrayList<>(asList(new Student(1,"Deku"), new Student(2,"Todoroki")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
