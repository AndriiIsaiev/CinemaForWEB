package com.abi.cinema.db.connection;

import com.abi.cinema.db.connection.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OneConnection {
    Connection oneConnection;
    boolean connectionFree;

    private OneConnection() {
        oneConnection = null;
        connectionFree = false;
    }

    public static OneConnection initConnection(String url) throws SQLException {
        OneConnection con = new OneConnection();
//        con.oneConnection = DriverManager.getConnection(url);
        con.oneConnection = DBUtils.getInstance().getConnection();
        con.connectionFree = true;
        return con;
    }

    public void busyConnection() {
        connectionFree = false;
    }

    public void releaseConnection() {
        connectionFree = true;
    }

    public Connection getOneConnection() {
        return oneConnection;
    }

    public boolean isConnectionFree() {
        return connectionFree;
    }

}
