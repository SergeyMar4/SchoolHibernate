package com.sergeymar4.schoolhibernate.repositories;

import com.sergeymar4.schoolhibernate.models.Course;
import com.sergeymar4.schoolhibernate.models.Mark;
import com.sergeymar4.schoolhibernate.models.SchoolClass;
import com.sergeymar4.schoolhibernate.models.Student;
import com.sergeymar4.schoolhibernate.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentRepository {

    public Student getById(int id) {
        Student student = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            student = session.get(Student.class, id);
        }

        return student;
    }

    public List<Student> getAll() {
        List<Student> students = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            students = session.createQuery("from Student").list();
        }

        return students;
    }

    public void create(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        }
    }

    public void update(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        }
    }

    public void delete(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
        }
    }

    public List<Mark> getAllMarksByCourse(int student_id, int course_id) {
        List<Mark> marks = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("from Mark where student_id=:student_id and course_id=:course_id");
            query.setParameter("student_id", student_id);
            query.setParameter("course_id", course_id);
            marks = query.list();
        }

        return marks;
    }
}
