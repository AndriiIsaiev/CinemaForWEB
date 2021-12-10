package com.abi.cinema.db.connection;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UrlConnection {
    private String url;

    public UrlConnection(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

//    File file = new File("app.properties");
//    Properties properties = new Properties();
//        try {
//        properties.load(new FileReader(file));
//    } catch (
//    IOException e) {
//        Logger.getLogger(Scanner.class.getName()).log(Level.SEVERE, null, e);
//    }
//    Connection con = null;
//        try {
//        con = DriverManager.getConnection(properties.getProperty("connection.url"));
//    }catch (
//    SQLException e) {
//        Logger.getLogger(Scanner.class.getName()).log(Level.SEVERE, null, e);
//    }

}
