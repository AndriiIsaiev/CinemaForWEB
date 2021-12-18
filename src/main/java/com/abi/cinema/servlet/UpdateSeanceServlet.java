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


@WebServlet("/updateSeance")
public class UpdateSeanceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("updateSeanceServlet#doPost");

        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        Seance updateSeance = new Seance();
        try {
            updateSeance = new Seance( Integer.parseInt(req.getParameter("id")),
                                            Integer.parseInt(req.getParameter("filmId")),
                                    req.getParameter("seanceDate") + " " + req.getParameter("seanceTime") + ":00",
                                            Float.parseFloat(req.getParameter("seanceCost")));
        } catch (IllegalArgumentException ex) {
            session.setAttribute("updateSeance", updateSeance);
            session.setAttribute("textError", "Не корректная дата или время");
            resp.sendRedirect("formeditseance.jsp");
            return;
        }
        String textError = UtilsForServlets.validSeance(updateSeance, req, resp);
        if (textError.equals("")) {
            SeanceDAO.updateSeanceBySeance(updateSeance);
            UtilsForServlets.listSeance(req, resp);
        } else {
            session.setAttribute("updateSeance", updateSeance);
            session.setAttribute("textError", textError);
            resp.sendRedirect("formeditseance.jsp");
        }
    }
}