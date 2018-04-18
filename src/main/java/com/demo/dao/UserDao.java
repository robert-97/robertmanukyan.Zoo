package com.demo.dao;

import com.demo.models.User;

import java.sql.*;

/**
 * Created by robert.manukyan on 3/19/2018.
 */

public class UserDao {

    private String connectURL = "jdbc:sqlserver://SIS4W009\\SQLEXPRESS:1433;dataBaseName = user; ";
    private String login = "sa";
    private String password = "Robert#banan";
    private Connection connection;

    public UserDao() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection(connectURL, login, this.password);
    }

    public User getUser(String userName, String password) throws ClassNotFoundException, SQLException {

        String sql = "SELECT * FROM dbo.users WHERE (name = ? AND password= ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);
        ResultSet result = preparedStatement.executeQuery();

        if (result.next()) {
            User user = new User();
            user.setUsername(result.getString("name"));
            user.setPassword(result.getString("password"));
            user.setRole(result.getString("role"));
            return user;
        }
        return null;

    }

    public void userRegistration(String userName, String password, String role) throws SQLException {
        String sql = "INSERT INTO dbo.users (name, password, role)" +
                "VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, role);
        preparedStatement.executeUpdate();
    }

}
