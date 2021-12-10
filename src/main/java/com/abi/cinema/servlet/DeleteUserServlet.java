package com.abi.cinema.servlet;

import com.abi.cinema.db.dao.FilmDAO;
import com.abi.cinema.db.dao.UserDAO;
import com.abi.cinema.db.entity.Film;
import com.abi.cinema.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("deleteUserServlet#doGet");

        UserDAO.deleteUserById(Integer.parseInt(req.getParameter("id")));
        UtilsForServlets.listUser(req, resp);
    }
}