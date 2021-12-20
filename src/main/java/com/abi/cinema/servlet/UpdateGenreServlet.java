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
import java.util.List;


@WebServlet("/updateGenre")
public class UpdateGenreServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("updateGenreServlet#doPost");

        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        Genre updateGenre = new Genre(  Integer.parseInt(req.getParameter("id")),
                                        req.getParameter("name"));

        String textError = UtilsForServlets.validGenre(updateGenre, req, resp);
        if (textError.equals("inall.errorfree")) {
            GenreDAO.updateGenreByGenre(updateGenre);
            UtilsForServlets.listGenre(req, resp);
        } else {
            session.setAttribute("updateGenre", updateGenre);
            session.setAttribute("textError", textError);
            resp.sendRedirect("formeditgenre.jsp");
        }
    }
}