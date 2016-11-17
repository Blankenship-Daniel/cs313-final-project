/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cs313.finalproject;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database
 * @author dblankenship
 */
public class Database {
    
    //
    // These are two different ways to create a database connection with a 
    //  heroku database. You can find out more here:
    //      https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java
    //
    
    static Connection getConnection() throws URISyntaxException, SQLException {
        String DATABASE_URL = "postgres://xspqcmuvzaxikz:JqzTDYNVg2E2rF8NhlrbL2XQDj@ec2-54-227-250-80.compute-1.amazonaws.com:5432/decls0ut7jh0lr";
        URI dbUri = new URI(DATABASE_URL);

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }
}
