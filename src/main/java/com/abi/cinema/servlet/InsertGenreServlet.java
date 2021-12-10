package com.abi.cinema.servlet;

import com.abi.cinema.db.dao.GenreDAO;
import com.abi.cinema.db.entity.Genre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


@WebServlet("/insertGenre")
public class InsertGenreServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("insertGenreServlet#doPost");

        req.setCharacterEncoding("UTF-8");
        Genre insertGenre = new Genre(req.getParameter("name"));

        String textError = UtilsForServlets.validGenre(insertGenre, req, resp);
        if (textError.equals("")) {
            GenreDAO.insertGenre(insertGenre);
            UtilsForServlets.listGenre(req, resp);
        } else {
            req.setAttribute("textError", textError);
            req.setAttribute("insertGenre", insertGenre);
            req.getRequestDispatcher("forminsertgenre.jsp").forward(req, resp);
        }
    }
}