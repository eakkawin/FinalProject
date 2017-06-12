package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Device;
import model.User;

/**
 *
 * @author user
 */
public class LoginServlet extends HttpServlet {

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
        if (request.getSession().getAttribute("user") != null) {
            User u = (User) request.getSession().getAttribute("user");
           
                getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);
           
        }

        System.out.println("jjjjj");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.trim().length() == 0 || password.trim().length() == 0) {
            request.setAttribute("msg", "Incorrect username or password !!");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            List<User> u = User.findUser(username, password);
            if (u.size() == 0) {
                System.out.println("e");
                request.setAttribute("msg", "Incorrect username or password !!");
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                System.out.println("ee");
                User user = u.get(0);
                request.getSession().setAttribute("user", user);
                
                    getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);
                
            }
        }

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
