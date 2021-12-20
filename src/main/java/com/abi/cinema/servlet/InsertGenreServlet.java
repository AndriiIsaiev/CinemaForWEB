package com.abi.cinema.servlet;

import com.abi.cinema.db.dao.GenreDAO;
import com.abi.cinema.db.entity.Genre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


@WebServlet("/insertGenre")
public class InsertGenreServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("insertGenreServlet#doPost");

        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        Genre insertGenre = new Genre(req.getParameter("name"));

        String textError = UtilsForServlets.validGenre(insertGenre, req, resp);
        if (textError.equals("inall.errorfree")) {
            GenreDAO.insertGenre(insertGenre);
            UtilsForServlets.listGenre(req, resp);
        } else {
            session.setAttribute("insertGenre", insertGenre);
            session.setAttribute("textError", textError);
            resp.sendRedirect("forminsertgenre.jsp");
        }
    }
}