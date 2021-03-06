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

        HttpSession session = req.getSession();
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
        if (textError.equals("inall.errorfree")) {
            UserDAO.insertUser(insertUser);
            UtilsForServlets.listUser(req, resp);
        } else {
            session.setAttribute("insertUser", insertUser);
            session.setAttribute("password1", req.getParameter("password1"));
            session.setAttribute("textError", textError);
            resp.sendRedirect("forminsertuser.jsp");
        }
    }
}