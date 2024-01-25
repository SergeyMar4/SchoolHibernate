package com.sergeymar4.schoolhibernate.repositories;

import com.sergeymar4.schoolhibernate.models.Course;
import com.sergeymar4.schoolhibernate.models.Mark;
import com.sergeymar4.schoolhibernate.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MarkRepository {

    public Mark getById(int id) {
        Mark mark = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            mark = session.get(Mark.class, id);
        }

        return mark;
    }

    public void create(Mark mark) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(mark);
            transaction.commit();
        }
    }

    public void update(Mark mark) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(mark);
            transaction.commit();
        }
    }

    public void delete(Mark mark) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(mark);
            transaction.commit();
        }
    }
}
