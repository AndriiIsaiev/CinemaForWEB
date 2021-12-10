package com.abi.cinema.servlet;

import com.abi.cinema.db.dao.GenreDAO;
import com.abi.cinema.db.entity.Genre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/formInsertGenre")
public class FormInsertGenreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("formInsertGenreServlet#doGet");

        int id = Integer.parseInt(req.getParameter("id"));
        if (id == -1) {
            Genre insertGenre = new Genre("");
            req.setAttribute("insertGenre", insertGenre);
            req.getRequestDispatcher("forminsertgenre.jsp").forward(req, resp);
        }
        UtilsForServlets.listGenre(req, resp);
    }
}