package com.abi.cinema.servlet;

import com.abi.cinema.db.dao.UserDAO;
import com.abi.cinema.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/logoutUser")
public class LogoutUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("logoutUserServlet#doGet");

        HttpSession session = req.getSession();
        System.out.println(session.getId());
        System.out.println(session.isNew());
        session.setAttribute("currentUser", null);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}