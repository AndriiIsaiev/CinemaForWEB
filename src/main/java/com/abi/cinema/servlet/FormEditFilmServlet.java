package com.abi.cinema.servlet;

import com.abi.cinema.db.dao.FilmDAO;
import com.abi.cinema.db.dao.GenreDAO;
import com.abi.cinema.db.entity.Film;
import com.abi.cinema.db.entity.Genre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/formEditFilm")
public class FormEditFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("formEditFilmServlet#doGet");

        HttpSession session = req.getSession();
        int id = Integer.parseInt(req.getParameter("id"));
        if (id != -1) {
            Film editFilm = FilmDAO.getFilmById(id);
            if (editFilm != null) {
                session.setAttribute("editFilm", editFilm);
                session.setAttribute("textError", "");
                req.getRequestDispatcher("formeditfilm.jsp").forward(req, resp);
            }
        } else {
            UtilsForServlets.listGenre(req, resp);
        }
    }
}