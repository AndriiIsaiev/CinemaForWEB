package com.abi.cinema.servlet;

import com.abi.cinema.db.dao.ReservePool;
import com.abi.cinema.db.dao.SeatDAO;
import com.abi.cinema.db.dao.UniversalDAO;
import com.abi.cinema.db.entity.Seat;
import com.abi.cinema.db.entity.Ticket;
import com.abi.cinema.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/payTicket")
public class PayTicketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("payTicketServlet#doGet");

        synchronized(ReservePool.MONITOR) {
            HttpSession session = req.getSession();
            User currentUser = (User) session.getAttribute("currentUser");
            int sizeAllTicket = (int) session.getAttribute("sizeAllTicket");
            List<Ticket> payTicket = new ArrayList<>();
            if (currentUser != null) {
                payTicket = ReservePool.getTicketByUser(currentUser);
            }

            String paymentSuccess = "seance.Paymentfailedreservedticketsoutoftime";
            if (payTicket.size() == sizeAllTicket) {
                paymentSuccess = "seance.Paymentfailed";
                if (UniversalDAO.payTicketTransaction(payTicket)) {
                    paymentSuccess = "seance.Paymentsuccessful";
                }
            }
            req.setAttribute("paymentSuccess", paymentSuccess);
            req.getRequestDispatcher("paymentsuccess.jsp").forward(req, resp);
        }
    }
}