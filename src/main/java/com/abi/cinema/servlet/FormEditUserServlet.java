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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/formEditUser")
public class FormEditUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("formEditUserServlet#doGet");

        HttpSession session = req.getSession();
        int id = Integer.parseInt(req.getParameter("id"));
        if (id != -1) {
            User editUser = UserDAO.getUserById(id);
            if (editUser != null) {
                session.setAttribute("editUser", editUser);
                session.setAttribute("password1", editUser.getPassword());
                session.setAttribute("textError", "");
                req.getRequestDispatcher("formedituser.jsp").forward(req, resp);
            }
        } else {
            UtilsForServlets.listUser(req, resp);
        }
    }
}