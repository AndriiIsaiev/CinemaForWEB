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
import java.io.IOException;
import java.util.List;


@WebServlet("/deleteGenre")
public class DeleteGenreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("deleteGenreServlet#doGet");

        GenreDAO.deleteGenreById(Integer.parseInt(req.getParameter("id")));
        UtilsForServlets.listGenre(req, resp);
    }
}