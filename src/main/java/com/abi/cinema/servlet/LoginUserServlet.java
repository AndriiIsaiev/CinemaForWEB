package com.abi.cinema.servlet;

import com.abi.cinema.db.dao.Item;
import com.abi.cinema.db.dao.UserDAO;
import com.abi.cinema.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/loginUser")
public class LoginUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("loginUserServlet#doPost");

        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        User loginUser = new User(  req.getParameter("login"),
                                    req.getParameter("password"));

        String textError = UtilsForServlets.validLoginUser(loginUser, req, resp);
        if (textError.equals("inall.errorfree")) {
            List<Item> filter = new ArrayList<>();
            filter.add(new Item("", "email", "=", loginUser.getEmail()));
            filter.add(new Item("AND", "password", "=", loginUser.getPassword()));
            User currentUser = UserDAO.getUserByFilter(filter).get(0);
            session.setAttribute("currentUser", currentUser);
            resp.sendRedirect("index.jsp");
        } else {
            session.setAttribute("currentUser", null);
            session.setAttribute("textError", textError);
            resp.sendRedirect("formloginuser.jsp");
        }
    }
}