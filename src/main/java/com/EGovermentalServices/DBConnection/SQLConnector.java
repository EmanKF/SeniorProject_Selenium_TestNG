package com.EGovermentalServices.DBConnection;

import java.sql.*;

public class SQLConnector {

    //Database URL
    String dbUrl;

    //Database Username
    String username;

    //Database Password
     String password;

    public SQLConnector(){
        dbUrl = "jdbc:mysql://localhost:3306/seniorproject?allowPublicKeyRetrieval=true&useSSL=false";
        username = "root";
        password = "ema20pilot9k1999";
    }

    public Connection ConnectToDB() throws SQLException, ClassNotFoundException {

        //Load mysql jdbc driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl,username,password);
        return con;
    }

    public ResultSet getCitizenByID(String ID) throws SQLException, ClassNotFoundException {

        String query = "select * from citizens;";

        SQLConnector sqlC=new SQLConnector();
        Connection con = sqlC.ConnectToDB();
        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);


        return rs;
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //Query to Execute
        String query = "select UserName,Email  from account;";

        SQLConnector sqlC=new SQLConnector();
       Connection con = sqlC.ConnectToDB();
        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results
        while (rs.next()){
            String myName = rs.getString(1);
            String myEmail = rs.getString(2);
            System. out.println(myName+"  "+myEmail);
        }
        // closing DB Connection
        con.close();
    }


}
