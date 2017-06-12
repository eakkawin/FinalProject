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
public class Device implements Serializable {

    private int deviceId;
    private String deviceName;
    private String status;
    private int roomId;
    private String macAddress;
    private String cmd;

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }
    
    public static Device getCMDByID(int id) {
        Device device = null;
        SessionFactory factory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            factory = new AnnotationConfiguration().configure().buildSessionFactory();
            session = factory.openSession();
            transaction = session.beginTransaction();
            device = (Device) session.get(Device.class, id);
           
        } catch (HibernateException e) {
            transaction.rollback();
            System.out.println(e);
        } finally {
            session.close();
            factory.close();
        }
        return device;
    }
  
    public static List findDeviceByRoom(int roomId) {
        List devices = null;
        SessionFactory factory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            factory = new AnnotationConfiguration().configure().buildSessionFactory();
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query q = session.createQuery(" From Device where room_id =:r");
            q.setInteger("r", roomId);
            devices = q.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.out.println(e);
        } finally {
            session.close();
            factory.close();
        }
        return devices;
    }
  
    
    public static void updateDevice(Device d) {
        SessionFactory factory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            factory = new AnnotationConfiguration().configure().buildSessionFactory();
            session = factory.openSession();
            transaction = session.beginTransaction();
            Device device = (Device) session.get(Device.class, d.getDeviceId());
            if(d.getStatus().equalsIgnoreCase("on")){
                 device.setStatus("OFF");
            }else{
              device.setStatus("ON");
            }
           
            session.update(device);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.out.println(e);
        } finally {
            session.close();
            factory.close();
        }

    }

}
