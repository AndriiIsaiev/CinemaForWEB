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
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@WebServlet("/insertUser")
public class InsertUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("insertUserServlet#doPost");

        req.setCharacterEncoding("UTF-8");
        User insertUser = new User(  req.getParameter("email"),
                new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()),
                                        req.getParameter("password"),
                                        req.getParameter("role") == null ? 0 : 1,
                                        req.getParameter("name"),
                                        req.getParameter("surname"),
                                        req.getParameter("phone"),
                                        req.getParameter("mailing") == null ? 0 : 1);

        String textError = UtilsForServlets.validUser(insertUser, req, resp);
        if (textError.equals("")) {
            UserDAO.insertUser(insertUser);
            UtilsForServlets.listUser(req, resp);
        } else {
            req.setAttribute("textError", textError);
            req.setAttribute("password1", req.getParameter("password1"));
            req.setAttribute("insertUser", insertUser);
            req.getRequestDispatcher("forminsertuser.jsp").forward(req, resp);
        }
    }
}