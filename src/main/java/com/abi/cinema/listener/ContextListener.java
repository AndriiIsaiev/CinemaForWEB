package com.abi.cinema.listener;

import com.abi.cinema.db.connection.ConnectionManager;
import com.abi.cinema.db.connection.UrlConnection;
import com.abi.cinema.db.dao.ReservePool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class ContextListener implements ServletContextListener {
    final Logger log = LogManager.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        String path = ctx.getRealPath("/WEB-INF/log4j2.log");
        System.setProperty("logFile", path);
        final Logger log = LogManager.getLogger(ContextListener.class);
        log.debug("path = " + path);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        UrlConnection url = new UrlConnection("jdbc:mysql://localhost:3306/cinema?user=root&password=3306");
        try {
            ConnectionManager.getInstance(url, 3);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        new Thread() {
            {
                setDaemon(true);
            }

            public void run() {
                while (true) {
                    try {
                        sleep(ReservePool.SLEEP_CYCLE);
                        ReservePool.cleanPool();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
