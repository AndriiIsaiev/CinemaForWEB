package com.abi.cinema.servlet;

import com.abi.cinema.db.dao.*;
import com.abi.cinema.db.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


@WebServlet("/formBuyTicket")
public class FormBuyTicketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("formBuyTicketServlet#doPost");

        HttpSession session = req.getSession();
        System.out.println(session.getId());
        System.out.println(session.isNew());

        int id = Integer.parseInt(req.getParameter("id"));
        Seance buySeance = SeanceDAO.getSeanceById(id);
        session.setAttribute("buySeance", buySeance);

        String seanceDateTime = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(buySeance.getDateTime());
        session.setAttribute("seanceDateTime", seanceDateTime);

        Film film = FilmDAO.getFilmById(buySeance.getFilmId());
        session.setAttribute("film", film);

        String buyError = "";
        session.setAttribute("buyError", buyError);

        UtilsForServlets.fillSeatInHall(req);

        req.getRequestDispatcher("formbuyticket.jsp").forward(req, resp);
    }
}