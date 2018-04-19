package com.demo.animalsGetter;

import com.demo.dao.ZooDao;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by robert.manukyan on 16.04.2018.
 */

public class AnimalsGetter extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getAnimals(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getAnimals(request, response);
    }

    /**
     * load animals from DB
     * @param request
     * @param response
     */

    public void getAnimals(HttpServletRequest request, HttpServletResponse response) {

        Integer cageID = Integer.parseInt(request.getParameter("cageNumberID").trim());

        try {
            ZooDao zooDao = new ZooDao();

            String json = new Gson().toJson(zooDao.getAnimalsInCage(cageID));
            response.getWriter().write(json);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
