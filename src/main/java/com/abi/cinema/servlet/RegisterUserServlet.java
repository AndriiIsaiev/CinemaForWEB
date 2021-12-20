package com.abi.cinema.servlet;

import com.abi.cinema.db.dao.UserDAO;
import com.abi.cinema.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("registerUserServlet#doPost");

        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        User registerUser = new User(  req.getParameter("email"),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),
                                        req.getParameter("password"),
                                        0,
                                        req.getParameter("name"),
                                        req.getParameter("surname"),
                                        req.getParameter("phone"),
                                        req.getParameter("mailing") == null ? 0 : 1);

        String textError = UtilsForServlets.validUser(registerUser, req, resp);
        if (textError.equals("inall.errorfree")) {
            UserDAO.insertUser(registerUser);
            resp.sendRedirect("index.jsp");
        } else {
            session.setAttribute("textError", textError);
            session.setAttribute("registerUser", registerUser);
            session.setAttribute("password1", req.getParameter("password1"));
            resp.sendRedirect("formregisteruser.jsp");
        }
    }
}