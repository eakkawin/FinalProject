/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author user
 */
public class User implements Serializable {

    private int userId;
    private String username;
    private String password;
    private String role;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static List findUser(String username, String password) {
        System.out.println("hellll");
        List<User> u = null;
        Transaction tx = null;
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new AnnotationConfiguration().configure().buildSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();
            Query q = session.createQuery("From User where Username =:u and Password =:p");
            q.setString("u", username);
            q.setString("p", password);
            u = q.list();
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            System.out.println(e);
        } finally {
            session.close();
            factory.close();
        }
        return u;
    }

    public static void main(String[] args) {
        List u = findUser("test", "test");

    }

    public static void insertUsers(User u) {
        Transaction tx = null;
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new AnnotationConfiguration().configure().buildSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();
            session.save(u);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            System.out.println(e);
        } finally {
            session.close();
            factory.close();
        }
    }
}
