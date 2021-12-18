package com.abi.cinema.servlet;

import com.abi.cinema.db.dao.FilmDAO;
import com.abi.cinema.db.dao.GenreDAO;
import com.abi.cinema.db.entity.Film;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/insertFilm")
public class InsertFilmServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("insertFilmServlet#doPost");

        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        Film insertFilm = new Film();
        try {
            insertFilm = new Film(  req.getParameter("title"),
                                        req.getParameter("year"),
                                        req.getParameter("studio"),
                                        req.getParameter("length") + ":00",
                                        Integer.parseInt(req.getParameter("ageCategory")),
                                        req.getParameter("description"),
                                "./img/" +  req.getParameter("photoURL"));
        } catch (IllegalArgumentException ex) {
            session.setAttribute("insertFilm", insertFilm);
            session.setAttribute("textError", "Не корректная длительность фильма");
            resp.sendRedirect("forminsertfilm.jsp");
            return;
        }
        String textError = UtilsForServlets.validFilm(insertFilm, req, resp);
        if (textError.equals("")) {
            FilmDAO.insertFilm(insertFilm);
            UtilsForServlets.listFilm(req, resp);
        } else {
            session.setAttribute("insertFilm", insertFilm);
            session.setAttribute("textError", textError);
            resp.sendRedirect("forminsertfilm.jsp");
        }
    }
}