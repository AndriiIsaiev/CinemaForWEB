package com.abi.cinema.servlet;

import com.abi.cinema.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/formRegisterUser")
public class FormRegisterUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("formRegisterUserServlet#doGet");

        User registerUser = new User("", "");
        req.setAttribute("registerUser", registerUser);
        req.setAttribute("password1", registerUser.getPassword());
        req.setAttribute("textError", "");
        req.getRequestDispatcher("formregisteruser.jsp").forward(req, resp);
    }
}