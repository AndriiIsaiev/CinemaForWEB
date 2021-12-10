package com.abi.cinema.servlet;

import com.abi.cinema.db.dao.FilmDAO;
import com.abi.cinema.db.entity.Film;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/formInsertFilm")
public class FormInsertFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("formInsertFilmServlet#doGet");

        Integer id = Integer.parseInt(req.getParameter("id"));
        if (id == -1) {
            Film insertFilm = new Film("");
            req.setAttribute("insertFilm", insertFilm);
            req.getRequestDispatcher("forminsertfilm.jsp").forward(req, resp);
        }
        UtilsForServlets.listGenre(req, resp);
    }
}