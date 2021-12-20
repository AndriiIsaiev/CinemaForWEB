package com.abi.cinema.servlet;

import com.abi.cinema.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/formRegisterUser")
public class FormRegisterUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("formRegisterUserServlet#doGet");

        HttpSession session = req.getSession();
        User registerUser = new User("", "");
        session.setAttribute("registerUser", registerUser);
        session.setAttribute("password1", registerUser.getPassword());
        session.setAttribute("textError", "inall.errorfree");
        req.getRequestDispatcher("formregisteruser.jsp").forward(req, resp);
    }
}