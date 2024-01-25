package com.sergeymar4.schoolhibernate.controllers;

import com.sergeymar4.schoolhibernate.models.Student;
import com.sergeymar4.schoolhibernate.repositories.SchoolClassRepository;
import com.sergeymar4.schoolhibernate.repositories.StudentRepository;

import java.util.List;

public class StudentController {
    private StudentRepository studentRepository;
    private SchoolClassRepository schoolClassRepository;

    public StudentController() {
        this.studentRepository = new StudentRepository();
        this.schoolClassRepository = new SchoolClassRepository();
    }

    public Student getById(int id) {
        return studentRepository.getById(id);
    }

    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    public void create(int class_id, String firstName, String lastName, int age) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAge(age);
        student.setSchoolClass(schoolClassRepository.getById(class_id));
        studentRepository.create(student);
    }

    public void update(int id, int class_id, String firstName, String lastName, int age) {
        Student student = studentRepository.getById(id);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAge(age);
        student.setSchoolClass(schoolClassRepository.getById(class_id));
    }

    public void delete(int id) {
        studentRepository.delete(studentRepository.getById(id));
    }
}
