package com.example.registrationappwithspring;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseHandler extends Configs{
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void SignUpUser(String firstname, String lastname, String username, String password){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME  + "," + Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + ")" + "VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,firstname);
            prSt.setString(2,lastname);
            prSt.setString(3,username);
            prSt.setString(4,password);
            prSt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public List SelectFromDB(){
        List<String> usersList = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT * FROM sql_app";

        try {
            ps = getDbConnection().prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()){
                String username = rs.getString(4);
                String password = rs.getString(5);
                String[] UserAndPass = new String[2];
                UserAndPass[0] = username;
                UserAndPass[1] = password;
                usersList.add(Arrays.toString(UserAndPass));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(usersList);
        return usersList;
    }
}
