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
public class Room implements Serializable {

    private int roomId;
    private String building;
    private String roomName;
    private String floor;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public static List findAllRooms() {
        List rooms = null;
        SessionFactory factory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            factory = new AnnotationConfiguration().configure().buildSessionFactory();
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query q = session.createQuery("From Room");
            rooms = q.list();
            transaction.commit();
            
        } catch (HibernateException e) {
            transaction.rollback();
            System.out.println(e);
        }finally {
            session.close();
            factory.close();
        }
        return rooms;
    }
}
