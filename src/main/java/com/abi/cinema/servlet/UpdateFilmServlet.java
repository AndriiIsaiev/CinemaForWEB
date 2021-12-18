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


@WebServlet("/updateFilm")
public class UpdateFilmServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("updateFilmServlet#doPost");

        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        Film updateFilm = new Film();
        try {
            updateFilm = new Film( Integer.parseInt(req.getParameter("id")),
                                        req.getParameter("title"),
                                        req.getParameter("year"),
                                        req.getParameter("studio"),
                                        req.getParameter("length"),
                                        Integer.parseInt(req.getParameter("ageCategory")),
                                        req.getParameter("description"),
                                "./img/" +  req.getParameter("photoURL"));
        } catch (IllegalArgumentException ex) {
            session.setAttribute("updateFilm", updateFilm);
            session.setAttribute("textError", "Не корректная длительность фильма");
            resp.sendRedirect("formeditfilm.jsp");
            return;
        }
        String textError = UtilsForServlets.validFilm(updateFilm, req, resp);
        if (textError.equals("")) {
            FilmDAO.updateFilmByFilm(updateFilm);
            UtilsForServlets.listFilm(req, resp);
        } else {
            session.setAttribute("updateFilm", updateFilm);
            session.setAttribute("textError", textError);
            resp.sendRedirect("formeditfilm.jsp");
        }
    }
}