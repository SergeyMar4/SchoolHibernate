package com.sergeymar4.schoolhibernate.repositories;

import com.sergeymar4.schoolhibernate.models.Course;
import com.sergeymar4.schoolhibernate.models.SchoolClass;
import com.sergeymar4.schoolhibernate.models.Student;
import com.sergeymar4.schoolhibernate.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SchoolClassRepository {

    public List<Student> getStudentByFirstName(int class_id, String firstName) {
        List<Student> students = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("from Student where firstName=:firstName, class_id=:class_id");
            query.setParameter("firstName", firstName);
            query.setParameter("class_id", class_id);
            students = query.list();
        }

        return students;
    }

    public void addStudent(SchoolClass schoolClass, Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            schoolClass.getStudents().add(student);
        }
    }

    public void addCourse(SchoolClass schoolClass, Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            schoolClass.getCourses().add(course);
            Transaction transaction = session.beginTransaction();
            session.update(schoolClass);
            transaction.commit();
        }
    }

    public void create(SchoolClass schoolClass) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(schoolClass);
            transaction.commit();
        }
    }

    public void update(SchoolClass schoolClass) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(schoolClass);
            transaction.commit();
        }
    }

    public void delete(SchoolClass schoolClass) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(schoolClass);
            transaction.commit();
        }
    }
}
