/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Device;
import model.Sender;
import model.Transaction;
import model.User;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author user
 */
public class TurningServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("user") == null) {
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
        int id = Integer.parseInt(request.getParameter("device_id"));
        String content = request.getParameter("content");
        Sender sender = new Sender();

        if (id > 20) {
            switch (id) {
                case 21:
                    for (int i = 1; i <= 4; i++) {
                        Device device = Device.getCMDByID(i);
                        String CMD = device.getCmd();
                        String msg = "Complete !!";
                        try {
                            sender.send(CMD, content);
                            Device.updateDevice(device);
                            Transaction trasaction = new Transaction();
                            trasaction.setDeviceId(id);
                            User u = (User) (request.getSession().getAttribute("user"));
                            if (device.getStatus().equalsIgnoreCase("on")) {
                                trasaction.setDesc("device has been off at " + new Date() + " By " + u.getUsername());
                            } else {
                                trasaction.setDesc("device has been on at " + new Date() + " By " + u.getUsername());
                            }
                            trasaction.setDateTime(new Date());
                            Transaction.insertTransaction(trasaction);
                        } catch (MqttException ex) {
                            msg = "Fail !!";
                            System.out.println(ex);
                        }
                        System.out.println(msg);
                        request.setAttribute("msg", msg);
                    }
                    break;
                case 22:
                    for (int i = 5; i <= 8; i++) {
                        Device device = Device.getCMDByID(i);
                        String CMD = device.getCmd();
                        String msg = "Complete !!";
                        try {
                            sender.send(CMD, content);
                            Device.updateDevice(device);
                            Transaction trasaction = new Transaction();
                            trasaction.setDeviceId(id);
                            User u = (User) (request.getSession().getAttribute("user"));
                            if (device.getStatus().equalsIgnoreCase("on")) {
                                trasaction.setDesc("device has been off at " + new Date() + " By " + u.getUsername());
                            } else {
                                trasaction.setDesc("device has been on at " + new Date() + " By " + u.getUsername());
                            }
                            trasaction.setDateTime(new Date());
                            Transaction.insertTransaction(trasaction);
                        } catch (MqttException ex) {
                            msg = "Fail !!";
                            System.out.println(ex);
                        }
                        System.out.println(msg);
                        request.setAttribute("msg", msg);
                    }
                    break;
                case 23:
                    for (int i = 9; i <= 12; i++) {
                        Device device = Device.getCMDByID(i);
                        String CMD = device.getCmd();
                        String msg = "Complete !!";
                        try {
                            sender.send(CMD, content);
                            Device.updateDevice(device);
                            Transaction trasaction = new Transaction();
                            trasaction.setDeviceId(id);
                            User u = (User) (request.getSession().getAttribute("user"));
                            if (device.getStatus().equalsIgnoreCase("on")) {
                                trasaction.setDesc("device has been off at " + new Date() + " By " + u.getUsername());
                            } else {
                                trasaction.setDesc("device has been on at " + new Date() + " By " + u.getUsername());
                            }
                            trasaction.setDateTime(new Date());
                            Transaction.insertTransaction(trasaction);
                        } catch (MqttException ex) {
                            msg = "Fail !!";
                            System.out.println(ex);
                        }
                        System.out.println(msg);
                        request.setAttribute("msg", msg);
                    }
                    break;
                case 24:
                    for (int i = 1; i <= 12; i++) {
                        Device device = Device.getCMDByID(i);
                        String CMD = device.getCmd();
                        String msg = "Complete !!";
                        try {
                            sender.send(CMD, content);
                            Device.updateDevice(device);
                            Transaction trasaction = new Transaction();
                            trasaction.setDeviceId(id);
                            User u = (User) (request.getSession().getAttribute("user"));
                            if (device.getStatus().equalsIgnoreCase("on")) {
                                trasaction.setDesc("device has been off at " + new Date() + " By " + u.getUsername());
                            } else {
                                trasaction.setDesc("device has been on at " + new Date() + " By " + u.getUsername());
                            }
                            trasaction.setDateTime(new Date());
                            Transaction.insertTransaction(trasaction);
                        } catch (MqttException ex) {
                            msg = "Fail !!";
                            System.out.println(ex);
                        }
                        System.out.println(msg);
                        request.setAttribute("msg", msg);
                    }
                    break;
                case 25:
                    for (int i = 16; i <= 17; i++) {
                        Device device = Device.getCMDByID(i);
                        String CMD = device.getCmd();
                        String msg = "Complete !!";
                        try {
                            sender.send(CMD, content);
                            Device.updateDevice(device);
                            Transaction trasaction = new Transaction();
                            trasaction.setDeviceId(id);
                            User u = (User) (request.getSession().getAttribute("user"));
                            if (device.getStatus().equalsIgnoreCase("on")) {
                                trasaction.setDesc("device has been off at " + new Date() + " By " + u.getUsername());
                            } else {
                                trasaction.setDesc("device has been on at " + new Date() + " By " + u.getUsername());
                            }
                            trasaction.setDateTime(new Date());
                            Transaction.insertTransaction(trasaction);
                        } catch (MqttException ex) {
                            msg = "Fail !!";
                            System.out.println(ex);
                        }
                        System.out.println(msg);
                        request.setAttribute("msg", msg);
                    }
                    break;
            }
        } else {

            Device device = Device.getCMDByID(id);
            String CMD = device.getCmd();
            String msg = "Complete !!";

            try {
                sender.send(CMD, content);
                Device.updateDevice(device);
                Transaction trasaction = new Transaction();
                trasaction.setDeviceId(id);
                User u = (User) (request.getSession().getAttribute("user"));
                if (device.getStatus().equalsIgnoreCase("on")) {
                    trasaction.setDesc("device has been off at " + new Date() + " By " + u.getUsername());
                } else {
                    trasaction.setDesc("device has been on at " + new Date() + " By " + u.getUsername());
                }
                trasaction.setDateTime(new Date());
                Transaction.insertTransaction(trasaction);
            } catch (MqttException ex) {
                msg = "Fail !!";
                System.out.println(ex);
            }
            System.out.println(msg);
            request.setAttribute("msg", msg);
        }

        getServletContext().getRequestDispatcher("/Room?id=1").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
