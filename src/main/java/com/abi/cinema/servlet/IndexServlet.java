package com.abi.cinema.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/Servlet#doGet");

        HttpSession session = req.getSession();
        System.out.println(session.getId());
        System.out.println(session.isNew());
        session.setAttribute("currentUser", null);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}