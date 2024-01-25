package com.sergeymar4.schoolhibernate.controllers;

import com.sergeymar4.schoolhibernate.models.SchoolClass;
import com.sergeymar4.schoolhibernate.models.Student;
import com.sergeymar4.schoolhibernate.repositories.CourseRepository;
import com.sergeymar4.schoolhibernate.repositories.SchoolClassRepository;
import com.sergeymar4.schoolhibernate.repositories.StudentRepository;

import java.util.List;

public class SchoolClassController {
    private SchoolClassRepository schoolClassRepository;
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    public SchoolClassController() {
        this.schoolClassRepository = new SchoolClassRepository();
        this.studentRepository = new StudentRepository();
        this.courseRepository = new CourseRepository();
    }

    public SchoolClass getById(int id) {
        return schoolClassRepository.getById(id);
    }

    public List<Student> getStudentByFirstName(int class_id, String firstName) {
        return schoolClassRepository.getStudentByFirstName(class_id, firstName);
    }

    public List<Student> detAll(int class_id) {
        return schoolClassRepository.getAll(class_id);
    }

    public void addStudent(int school_id, int student_id) {
        schoolClassRepository.addStudent(schoolClassRepository.getById(school_id), studentRepository.getById(student_id));
    }

    public void addCourse(int school_id, int course_id) {
        schoolClassRepository.addCourse(schoolClassRepository.getById(school_id), courseRepository.getById(course_id));
    }

    public void create(String title) {
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setTitle(title);
        schoolClassRepository.create(schoolClass);
    }

    public void update(int id, String title) {
        SchoolClass schoolClass = schoolClassRepository.getById(id);
        schoolClass.setTitle(title);
        schoolClassRepository.update(schoolClass);
    }

    public void delete(int id) {
        schoolClassRepository.delete(schoolClassRepository.getById(id));
    }
}
