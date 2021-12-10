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
import java.util.ArrayList;
import java.util.List;


@WebServlet("/bascket")
public class BuyTicketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("bascketServlet#doGet");

        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        List<Ticket> buyTicket = ReservePool.getTicketByUser(currentUser);
        int sizeAllTicket = buyTicket.size();
        req.setAttribute("sizeAllTicket", sizeAllTicket);

        int[] line = new  int[sizeAllTicket];
        int[] position = new  int[sizeAllTicket];
        float totalTotalCost = 0.0F;
        for (int i = 0; i < sizeAllTicket; i++) {
            Seat seat = SeatDAO.getSeatById(buyTicket.get(i).getSeatId());
            line[i] = seat.getLine();
            position[i] = seat.getPosition();
            totalTotalCost += buyTicket.get(i).getCost();
        }

        req.setAttribute("sizeAllTicket", sizeAllTicket);
        req.setAttribute("buyTicket", buyTicket);
        req.setAttribute("line", line);
        req.setAttribute("position", position);
        req.setAttribute("totalTotalCost", totalTotalCost);
        req.getRequestDispatcher("formconfirmbuy.jsp").forward(req, resp);

        UtilsForServlets.listSeance(req, resp);
    }
}