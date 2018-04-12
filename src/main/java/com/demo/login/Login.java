package com.demo.login;

import com.demo.dao.Dao;
import com.demo.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by robert.manukyan on 3/15/2018.
 */

public class Login extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userLoginCheck(request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userLoginCheck(request, response);
    }

    private void userLoginCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("userName") ;
        String password = request.getParameter("password") ;

        if ("".equals(username) || "".equals(password)) {
//            request.getRequestDispatcher("/").forward(request,response);
            response.sendRedirect("/");
            return;
        }

        try {
            Dao dao = new Dao();
            User user = dao.getUser(username, password);
            if (user != null) {
//                HttpSession session = request.getSession() ;
//                session.setAttribute((String) userRole.get(true), username);

                Cookie cookie = new Cookie("auth", user.getRole());
                cookie.setMaxAge(90);
                response.addCookie(cookie);

                response.sendRedirect("/empty.jsp");
                return;

            } else {
//              request.getRequestDispatcher("index.jsp").forward(request,response);
                response.sendRedirect("index.jsp");
                return;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
