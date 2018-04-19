package com.demo.dao;

import com.demo.models.Animal;
import com.demo.models.Cage;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by robert.manukyan on 12.04.2018.
 */
public class ZooDao {

    private String connectURL = "jdbc:sqlserver://SIS4W009\\SQLEXPRESS:1433;dataBaseName = zoo; ";
    private String login = "sa";
    private String password = "Robert#banan";
    private Connection connection;

    public ZooDao() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection(connectURL, login, this.password);
    }

    public List getCages() throws ClassNotFoundException, SQLException {

        String sql = "SELECT * FROM dbo.cage";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet result = preparedStatement.executeQuery();

        List<Cage> cagesList = new ArrayList<Cage>();
        while (result.next()) {
            Cage cage = new Cage(result.getInt(1), result.getInt(2));
            cagesList.add(cage);
        }
        connection.close();
        return cagesList;
    }

    public void addAnimal(String animalType, String cageID, String animalName) throws SQLException {
        String sql = "INSERT INTO dbo.animals ( animalType, animalName, cageID )" +
                "VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, animalType);
        preparedStatement.setString(2, animalName);
        preparedStatement.setInt(3, Integer.parseInt(cageID.trim()));
        preparedStatement.executeUpdate();
        connection.close();

    }

    public List getAnimalsInCage(Integer cageID) throws SQLException {
        String sql = "SELECT animalType,animalName FROM dbo.animals WHERE (cageID = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, cageID);

        ResultSet result = preparedStatement.executeQuery();

        List<Animal> animalList = new ArrayList<Animal>();

        while (result.next()) {
            Animal animal = new Animal(result.getString(1), result.getString(2));
            animalList.add(animal);
        }
        connection.close();
        return animalList;
    }
}
