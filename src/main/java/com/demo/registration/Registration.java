package com.demo.registration;

import com.demo.dao.UserDao;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 * Created by robert.manukyan on 3/15/2018.
 */


public class Registration extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userRegistration(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userRegistration(request, response);
    }


    /**
     * save received parameters into DB
     * @param request
     * @param response
     * @throws IOException
     */
    private void userRegistration(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("name");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        if ("".equals(userName) || "".equals(password) || "".equals(role)) {
            response.sendRedirect("/#");
            return;
        }

        response.setContentType("text/html");
        response.sendRedirect("/index.jsp");

        try {
            UserDao userDao = new UserDao();
            userDao.userRegistration(userName, password, role);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
