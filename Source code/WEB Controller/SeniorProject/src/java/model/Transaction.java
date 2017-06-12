/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;



public class Transaction {
    private int logId;
    private String desc;
    private int deviceId ;
    private Date dateTime;

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
    
    public static void insertTransaction(Transaction u){
      SessionFactory factory = null;
        Session session = null;
        try {
            factory = new AnnotationConfiguration().configure().buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            session.save(u);
            session.getTransaction().commit();
            System.out.println("inserted");
        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.out.println(e);
        } finally {
            if (session != null && factory != null) {
                session.close();
                factory.close();
            }
        }
    }
    public static List getTransactionByRoom(int rid){
         List transactions = null;
        SessionFactory factory = null;
        Session session = null;
        org.hibernate.Transaction transaction = null;
        try {
            factory = new AnnotationConfiguration().configure().buildSessionFactory();
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query q = session.createQuery("From Transaction where device_id =:r ORDER BY logId DESC");
            q.setInteger("r", rid);
            transactions = q.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.out.println(e);
        } finally {
            session.close();
            factory.close();
        }
        return transactions;
    }
    public static List getAllTransaction(){
      List transactions = null;
        SessionFactory factory = null;
        Session session = null;
        org.hibernate.Transaction transaction = null;
        try {
            factory = new AnnotationConfiguration().configure().buildSessionFactory();
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query q = session.createQuery("From Transaction ORDER BY logId DESC");
            transactions = q.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.out.println(e);
        } finally {
            session.close();
            factory.close();
        }
        return transactions;
    }
    
}
