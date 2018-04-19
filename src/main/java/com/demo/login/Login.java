package com.demo.login;

import com.demo.dao.UserDao;
import com.demo.models.User;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by robert.manukyan on 3/15/2018.
 */

public class Login extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userLoginCheck(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userLoginCheck(request, response);
    }

    private void userLoginCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("userName");
        String password = request.getParameter("password");

        if ("".equals(username) || "".equals(password)) {
//            request.getRequestDispatcher("/").forward(request,response);
            response.sendRedirect("/");
            return;
        }

        try {
            UserDao userDao = new UserDao();
            User user = userDao.getUser(username, password);
            if (user != null) {

                Cookie cookie = new Cookie("temp", user.getRole());
                cookie.setMaxAge(90);
                response.addCookie(cookie);

                response.sendRedirect("/welcome.jsp");
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
