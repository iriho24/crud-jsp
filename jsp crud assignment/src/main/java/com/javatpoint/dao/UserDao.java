package com.javatpoint.dao;

import com.javatpoint.bean.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserDao {

    private static SessionFactory factory;

    static {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public static int save(User user) {
        int status = 0;
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            status = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int update(User user) {
        int status = 0;
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            status = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int delete(User user) {
        int status = 0;
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
            status = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static List<User> getAllRecords() {
        List<User> userList = null;
        try (Session session = factory.openSession()) {
            userList = session.createQuery("FROM User").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static User getRecordById(int id) {
        User user = null;
        try (Session session = factory.openSession()) {
            user = session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
