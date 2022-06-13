/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ADMIN
 */
public class DBConnection {
    public static Connection GetConnection() {
      // final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
       //final String jdbcURL = "jdbc:mysql://localhost/shopshose";
       //final String jdbcUsername = "root";
       //final String jdbcpassword = "12345";
       final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
       final String jdbcURL = "jdbc:mysql://us-cdbr-east-04.cleardb.com/heroku_4eb21f9357fe5c3";
       final String jdbcUsername = "bc57686ba01b74";
       final String jdbcpassword = "aac02514";
        //final String jdbcURL = "jdbc:postgresql://ec2-3-212-168-103.compute-1.amazonaws.com/dbn8pcjgccp6ks";
       // final String jdbcUsername = "wwjsdnkjvulqbi";
        //final String jdbcpassword = "9c6ca1c1413bff12a322e1fc36c85630b20cc522b4e4be13cdbb8c39c5eb1e6a";
       // final String jdbcDriver = "org.postgresql.Driver";
        Connection con = null;
        try {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcpassword);

        } catch (ClassNotFoundException ex) {
            System.out.println("Loi driver");
        } catch (Exception e) {
            System.out.println("Loi ket noi");
        } finally {
            return con;
        }
    }
    	public static void main(String args[]) {
		Connection con = GetConnection();
		System.out.println(con);
	}

}
