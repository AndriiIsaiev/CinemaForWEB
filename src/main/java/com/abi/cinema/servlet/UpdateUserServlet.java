package com.abi.cinema.servlet;

import com.abi.cinema.db.dao.FilmDAO;
import com.abi.cinema.db.dao.Item;
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
import java.util.ArrayList;
import java.util.List;


@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("updateUserServlet#doPost");

        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        User updateUser = new User( Integer.parseInt(req.getParameter("id")),
                                    req.getParameter("email"),
                                    req.getParameter("createTime"),
                                    req.getParameter("password"),
                                    req.getParameter("role") == null ? 0 : 1,
                                    req.getParameter("name"),
                                    req.getParameter("surname"),
                                    req.getParameter("phone"),
                                    req.getParameter("mailing") == null ? 0 : 1);

        String textError = UtilsForServlets.validUser(updateUser, req, resp);
        if (textError.equals("inall.errorfree")) {
            UserDAO.updateUserByUser(updateUser);
            UtilsForServlets.listUser(req, resp);
        } else {
            session.setAttribute("updateUser", updateUser);
            session.setAttribute("password1", req.getParameter("password1"));
            session.setAttribute("textError", textError);
            resp.sendRedirect("formedituser.jsp");
        }
    }

}