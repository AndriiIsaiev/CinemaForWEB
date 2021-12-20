package com.abi.cinema.servlet;

import com.abi.cinema.db.dao.UserDAO;
import com.abi.cinema.db.entity.User;
import com.abi.cinema.listener.ContextListener;
import com.abi.cinema.listener.SessionListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/formLoginUser")
public class FormLoginUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("formLoginUserServlet#doGet");

        HttpSession session = req.getSession();
        session.setAttribute("textError", "inall.errorfree");
        req.getRequestDispatcher("formloginuser.jsp").forward(req, resp);
    }
}