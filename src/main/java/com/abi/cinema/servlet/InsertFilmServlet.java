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


@WebServlet("/insertFilm")
public class InsertFilmServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("insertFilmServlet#doPost");

        req.setCharacterEncoding("UTF-8");
        Film insertFilm = new Film(  req.getParameter("title"),
                                        req.getParameter("year"),
                                        req.getParameter("studio"),
                                        req.getParameter("length") + ":00",
                                        Integer.parseInt(req.getParameter("ageCategory")),
                                        req.getParameter("description"),
                                "./img/" +  req.getParameter("photoURL"));
        FilmDAO.insertFilm(insertFilm);

        UtilsForServlets.listFilm(req, resp);
    }
}