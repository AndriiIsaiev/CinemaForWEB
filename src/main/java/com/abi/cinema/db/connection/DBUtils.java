package com.abi.cinema.db.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtils {

//    private static DBUtils instance;
//
//    public static synchronized DBUtils getInstance() {
//        if (instance == null) {
//            instance = new DBUtils();
//        }
//        return instance;
//    }
//
//    private DataSource ds;
//
//    private DBUtils() {
//        try {
//            Context initContext = new InitialContext();
//            Context envContext  = (Context)initContext.lookup("java:/comp/env");
//            ds = (DataSource)envContext.lookup("jdbc/cinema");
//        } catch (NamingException ex) {
//            throw new IllegalStateException("Cannot obtain a data source", ex);
//        }
//    }
//
//    public Connection getConnection() {
//        Connection con = null;
//        try {
//            con = ds.getConnection();
//        } catch (SQLException ex) {
//            throw new IllegalStateException("Cannot obtain a connection", ex);
//        }
//        return con;
//    }

}