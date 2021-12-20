package com.abi.cinema.servlet;

import com.abi.cinema.db.dao.GenreDAO;
import com.abi.cinema.db.dao.ReservePool;
import com.abi.cinema.db.dao.SeatDAO;
import com.abi.cinema.db.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;


@WebServlet("/reserveSeat")
public class ReserveSeatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ReserveSeatServlet#doGet");

        HttpSession session = req.getSession();
        System.out.println(session.getId());
        System.out.println(session.isNew());

        int id = Integer.parseInt(req.getParameter("id"));
        Seat seat = SeatDAO.getSeatById(id);

        User currentUser = (User) session.getAttribute("currentUser");
        Seance buySeance = (Seance) session.getAttribute("buySeance");

        List<Ticket> listPoolTicket = ReservePool.getTicketBySeance(buySeance);

        Ticket removeAddTicket = null;
        for (Ticket t : listPoolTicket) {
            if (t.getUserId().equals(currentUser.getId()) & t.getSeatId().equals(seat.getId())) {
                removeAddTicket = t;
            }
        }
        if (removeAddTicket != null) {
            ReservePool.removeFromReservePool(removeAddTicket);
        } else {
            Film film = (Film) session.getAttribute("film");
            removeAddTicket = new Ticket(   buySeance.getId(),
                                            buySeance.getDateTime(),
                                            film.getTitle(),
                                            buySeance.getBaseCost(),
                                            currentUser.getId(),
                                            seat.getId(),
                                             new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),
                                            0);
            String buyError = "inall.errorfree";
            if (! ReservePool.addToReservePool(removeAddTicket)) {
                buyError = "seance.Thisseathasalreadybeenreserved";
            }
            session.setAttribute("buyError", buyError);
        }
        System.out.println("size " + ReservePool.reservePool.size());
        System.out.println("Pool " + ReservePool.reservePool);


        UtilsForServlets.fillSeatInHall(req);

        req.getRequestDispatcher("formbuyticket.jsp").forward(req, resp);
    }
}