package com.abi.cinema.servlet;

import com.abi.cinema.db.dao.UserDAO;
import com.abi.cinema.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/formLoginUser")
public class FormLoginUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("formLoginUserServlet#doGet");

        String textError = "";
        req.setAttribute("textError", "");
        req.getRequestDispatcher("formloginuser.jsp").forward(req, resp);
    }
}