package com.abi.cinema.db.connection;

import com.abi.cinema.db.connection.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionManager {
    private static ConnectionManager connectionManager;
    static ArrayList<OneConnection> poolConnection;

    private ConnectionManager() {
    }

    public static synchronized ConnectionManager getInstance(UrlConnection url, int maxTotal) throws SQLException {
        if (connectionManager == null) {
            connectionManager = new ConnectionManager();
            buildConnectionPool(url, maxTotal);
        }
        return connectionManager;
    }

    public static void buildConnectionPool(UrlConnection url, int maxTotal) throws SQLException {
        poolConnection = new ArrayList<OneConnection>();
        for (int i = 1; i <= maxTotal; i++) {
            OneConnection oc = OneConnection.initConnection(url.getUrl());
            poolConnection.add(oc);
        }
    }

    public static synchronized Connection giveMeConnection() {
        for(OneConnection oc : poolConnection) {
            if (oc.isConnectionFree()) {
                oc.busyConnection();
                return oc.getOneConnection();
            }
        }
        return null;
//        return DBUtils.getInstance().getConnection();
    }

    public static Connection takeBackConnection(Connection con) {
        for(OneConnection oc : poolConnection) {
            if (oc.getOneConnection() == con) {
                oc.releaseConnection();
                return null;
            }
        }
        return con;
//        try {
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
    }
}
