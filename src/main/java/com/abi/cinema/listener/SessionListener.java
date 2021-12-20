package com.abi.cinema.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
    final Logger LOG = LogManager.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession httpSession = httpSessionEvent.getSession();
        String id = httpSession.getId();
        if (httpSession.isNew()) {
            httpSession.setAttribute("sessionId", id);
        }
        LOG.debug("Start session" + id);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession httpSession = httpSessionEvent.getSession();
        if(httpSession.getAttribute("sessionId") != null) {
            String id = (String) httpSession.getAttribute("sessionId");
            LOG.debug("Session destroyed" + id);
            httpSession.removeAttribute("sessionId");
        }
    }
}
