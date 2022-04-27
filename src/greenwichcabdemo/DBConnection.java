/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwichcabdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;

/**
 *
 * @author ahmed
 */

public class DBConnection {

    private static final String Driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String url = "jdbc:derby:grennwichcabservice;create=true;";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(Driver);
            con = (Connection) DriverManager.getConnection(url);
               // Query for creating derby database.

//con.createStatement().execute("create table dispatchar(username varchar(30), password varchar(30))");
//con.createStatement().execute("INSERT INTO dispatchar VALUES ('test','123')");
// con.createStatement().execute("create table drivers (id VARCHAR(30) not null ,name VARCHAR(30) not null,"
// + "cell VARCHAR(30) not null,address VARCHAR(30) not null,"
//  + "carno VARCHAR(30) not null,gender VARCHAR(30) not null, "
//                    + "image blob(5MB),primary key (id))");
//            con.createStatement().execute("create table trips (tripid VARCHAR(40) not null ,"
//                    + "date VARCHAR(50) not null,time VARCHAR(30) not null,did VARCHAR(30) not null,"
//                    + "ppoint VARCHAR(80) not null,"
//                    + "dpoint VARCHAR(80) not null,pname VARCHAR(80) not null,pcell VARCHAR(80),"
//                    + " pmethod VARCHAR(80) not null, tips double, fare double, driverpay double,"
//                    + "status VARCHAR(80),primary key (tripid))");
        } catch (Exception e) {
            System.out.println("Unable to make connection with Database");
            e.printStackTrace();
        }

        return con;
    }

}
