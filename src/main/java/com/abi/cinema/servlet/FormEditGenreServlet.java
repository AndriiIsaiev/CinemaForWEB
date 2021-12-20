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
import java.util.List;


@WebServlet("/formEditGenre")
public class FormEditGenreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("formEditGenreServlet#doGet");

        HttpSession session = req.getSession();
        int id = Integer.parseInt(req.getParameter("id"));
        if (id != -1) {
            Genre editGenre = GenreDAO.getGenreById(id);
            if (editGenre != null) {
                session.setAttribute("editGenre", editGenre);
                session.setAttribute("textError", "inall.errorfree");
                req.getRequestDispatcher("formeditgenre.jsp").forward(req, resp);
            }
        } else {
            UtilsForServlets.listGenre(req, resp);
        }
    }
}