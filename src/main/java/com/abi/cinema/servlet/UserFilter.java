package com.abi.cinema.servlet;

import com.abi.cinema.db.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class UserFilter implements Filter {

    private static final String DEFAULT_PATH =
        "/index.jsp /listSeance" +
        "/formLoginUser /loginUser /logoutUser /formloginuser.jsp" +
        "/formRegisterUser /registerUser /formregisteruser.jsp";
    private static final String LOGGED_USER_PATH =
        "/index.jsp /listSeance /listFilm /listfilm.jsp" +
        "/formLoginUser /loginUser /logoutUser /formloginuser.jsp" +
        "/formRegisterUser /registerUser /formregisteruser.jsp" +
        "/reserveSeat /formBuyTicket /bascket /payTicket";
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpSession session = httpReq.getSession();

        User currentUser = (User) session.getAttribute("currentUser");

        System.out.println(httpReq.getServletPath());
        String httpPath = httpReq.getServletPath();

        if (currentUser == null) {
            if (DEFAULT_PATH.contains(httpPath) || httpPath.contains("/img")) {
                chain.doFilter(request, response);
                return;
            }
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
        if (currentUser.getRole() == 0) {
            if (LOGGED_USER_PATH.contains(httpPath) || httpPath.contains("/img")) {
                chain.doFilter(request, response);
                return;
            }
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }
}
