package com.abi.cinema.servlet;

import com.abi.cinema.db.dao.FilmDAO;
import com.abi.cinema.db.dao.SeanceDAO;
import com.abi.cinema.db.entity.Film;
import com.abi.cinema.db.entity.Seance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@WebServlet("/formEditSeance")
public class FormEditSeanceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("formEditSeanceServlet#doGet");

        HttpSession session = req.getSession();
        int id = Integer.parseInt(req.getParameter("id"));
        if (id != -1) {
            Seance editSeance = SeanceDAO.getSeanceById(id);
            if (editSeance != null) {
                String seanceDate = new SimpleDateFormat("yyyy-MM-dd").format(editSeance.getDateTime());
                String seanceTime = new SimpleDateFormat("HH:mm").format(editSeance.getDateTime());
                session.setAttribute("editSeance", editSeance);
                session.setAttribute("seanceTime", seanceTime);
                session.setAttribute("seanceDate", seanceDate);
                List<Film> listFilm = new ArrayList<>();
                listFilm = FilmDAO.getAllFilm();
                session.setAttribute("listFilm", listFilm);
                session.setAttribute("textError", "");
                req.getRequestDispatcher("formeditseance.jsp").forward(req, resp);
            }
        } else {
            UtilsForServlets.listSeance(req, resp);
        }
    }
}