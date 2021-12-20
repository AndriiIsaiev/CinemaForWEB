package com.abi.cinema.listener;

import com.abi.cinema.db.dao.ReservePool;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();

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
