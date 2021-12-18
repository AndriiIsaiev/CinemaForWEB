package com.abi.cinema.servlet;

import com.abi.cinema.db.dao.FilmDAO;
import com.abi.cinema.db.entity.Film;
import com.abi.cinema.db.entity.Seance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@WebServlet("/formInsertSeance")
public class FormInsertSeanceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("formInsertSeanceServlet#doGet");

        HttpSession session = req.getSession();
        int id = Integer.parseInt(req.getParameter("id"));
        if (id == -1) {
            Seance insertSeance = new Seance();
            insertSeance.setDateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            session.setAttribute("insertSeance", insertSeance);
            List<Film> listFilm = new ArrayList<>();
            listFilm = FilmDAO.getAllFilm();
            session.setAttribute("listFilm", listFilm);
            session.setAttribute("textError", "");
            req.getRequestDispatcher("forminsertseance.jsp").forward(req, resp);
        } else {
            UtilsForServlets.listSeance(req, resp);
        }
    }
}