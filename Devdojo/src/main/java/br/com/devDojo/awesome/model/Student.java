package br.com.devDojo.awesome.model;

import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Entity
public class Student extends AbstractEntity {

    static {
        studentRepository();
    }
    public static List<Student> studentList = new ArrayList<>();

    private String name;

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Student> getStudentList() {
        return studentList;
    }

    public static void setStudentList(List<Student> studentList) {
        Student.studentList = studentList;
    }

    public static void studentRepository() {
        studentList = new ArrayList<>(asList(new Student("Deku"), new Student("Todoroki")));
    }

    public Student(String name) {
        this.name = name;
    }
}
