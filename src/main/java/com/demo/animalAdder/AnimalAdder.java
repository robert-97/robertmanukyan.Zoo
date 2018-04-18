package com.demo.animalAdder;

import com.demo.dao.ZooDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by robert.manukyan on 12.04.2018.
 */
public class AnimalAdder extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addAnimalInCage(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addAnimalInCage(request, response);
    }

    private void addAnimalInCage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String animalType = request.getParameter("animalType");
        String cageID = request.getParameter("cageNumber");
        String animalName = request.getParameter("animalName");

        if ("".equals(animalType) && "".equals(animalName)) {
            response.sendRedirect("/welcome.jsp");
            return;
        }

        try {
            ZooDao zooDao = new ZooDao();
            zooDao.addAnimal(animalType, cageID, animalName);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/welcome.jsp");
    }
}
