package com.sergeymar4.schoolhibernate.controllers;

import com.sergeymar4.schoolhibernate.models.Course;
import com.sergeymar4.schoolhibernate.models.Mark;
import com.sergeymar4.schoolhibernate.models.Student;
import com.sergeymar4.schoolhibernate.repositories.SchoolClassRepository;
import com.sergeymar4.schoolhibernate.repositories.StudentRepository;
import com.sergeymar4.schoolhibernate.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.HashMap;
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
        studentRepository.update(student);
    }

    public void delete(int id) {
        studentRepository.delete(studentRepository.getById(id));
    }

    public List<Mark> getAllMarksByCourse(int student_id, int course_id, int quarter) {
        return studentRepository.getAllMarksByCourse(student_id, course_id, quarter);
    }

    public double getAverageScore(int student_id, int course_id, int quarter) {
        double sum = 0;

        List<Mark> marks = studentRepository.getAllMarksByCourse(student_id, course_id, quarter);

        for (Mark mark : marks) {
            sum += mark.getMark();
        }

        return sum / marks.size();
    }

    public HashMap<String, Double> getAverageScoreByAllCourse(int student_id, int quarter) {
        Student student = studentRepository.getById(student_id);
        List<Course> courses = student.getSchoolClass().getCourses();
        HashMap<String, Double> marks = new HashMap<String, Double>();

        for (Course course : courses) {
            marks.put(course.getTitle(), getAverageScore(student_id, course.getId(), quarter));
        }

        return marks;
    }

    public HashMap<String, Object> getAllMarksQuarter(int student_id, int quarter) {
        Student student = studentRepository.getById(student_id);
        List<Course> courses = student.getSchoolClass().getCourses();
        HashMap<String, Object> marksQuarter = new HashMap<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            for (Course course : courses) {
                if ((int) customRound(getAverageScore(student_id, course.getId(), quarter)) != 0) {
                    marksQuarter.put(course.getTitle(), (int) customRound(getAverageScore(student_id, course.getId(), quarter)));
                }
                else {
                    marksQuarter.put(course.getTitle(), "Нет данных!");
                }
            }

            return marksQuarter;
        }
    }

    public double customRound(double number) {
        double fractionalPart = number - (int) number;
        if (fractionalPart >= 0.5) {
            return Math.ceil(number);
        } else {
            return Math.floor(number);
        }
    }
}
