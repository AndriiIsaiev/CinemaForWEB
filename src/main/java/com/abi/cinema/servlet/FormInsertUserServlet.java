package com.abi.cinema.servlet;

import com.abi.cinema.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/formInsertUser")
public class FormInsertUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("formInsertUserServlet#doGet");

        HttpSession session = req.getSession();
        User insertUser = new User("", "");
        session.setAttribute("insertUser", insertUser);
        session.setAttribute("password1", insertUser.getPassword());
        session.setAttribute("textError", "inall.errorfree");
        req.getRequestDispatcher("forminsertuser.jsp").forward(req, resp);
    }
}