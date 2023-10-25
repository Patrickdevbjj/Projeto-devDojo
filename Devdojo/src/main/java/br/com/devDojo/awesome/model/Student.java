package br.com.devDojo.awesome.model;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Student {
    private int id;
    private String name;
    public static List<Student> studentList;
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
        studentList = new ArrayList<>(asList(new Student("Deku"), new Student("Todoroki")));

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
