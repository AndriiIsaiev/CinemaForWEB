package com.abi.cinema.db.dao;

import com.abi.cinema.db.entity.Entity;
import com.abi.cinema.db.entity.Seance;
import com.abi.cinema.db.entity.Ticket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {

    public static void insertTicket(Ticket ticket) throws IOException {
        if (getTicketByContent(ticket).size() == 0) {
            UniversalDAO.insertEntity("ticket", ticket);
        }
    }

    public static Ticket getTicketById(int id) throws IOException {
        return ((Ticket) UniversalDAO.getEntityById("ticket", id, new Ticket()));
    }

    public static List<Ticket> getTicketByContent(Ticket ticket) throws IOException {
        List<Item> filter = new ArrayList<>();
        filter.add(new Item("","seanceId", "=", ticket.getSeanceId()));
        filter.add(new Item("AND","seatId", "=", ticket.getSeatId()));
        List<Ticket> listTicket = getTicketByFilter(filter);
        return listTicket;
    }

    public static List<Ticket> getTicketBySeance(Seance seance) throws IOException {
        List<Item> filter = new ArrayList<>();
        filter.add(new Item("", "seanceId", "=", seance.getId() ));
        List<Ticket> listTicket = getTicketByFilter(filter);
        return listTicket;
    }

    public static List<Ticket> getTicketByFilter(List<Item> filter) throws IOException {
        return TicketDAO.getTicketBySQL("", filter, "");
    }

    public static List<Ticket> getTicketBySQL(String joinCondition, List<Item> whereCondition, String postCondition) throws IOException {
        List<Entity> listEntity = UniversalDAO.getEntityBySQL("ticket", joinCondition, whereCondition, postCondition, new Ticket());
        ArrayList<Ticket> listTicket = new ArrayList<>();
        for (Entity en : listEntity) {
            listTicket.add((Ticket) en);
        }
        return listTicket;
    }

    public static List<Ticket> getAllTicket() throws IOException {
        return getTicketByFilter(new ArrayList<>());
    }

    public static void deleteTicketById(int id) throws IOException {
        if (((Integer) id).equals(getTicketById(id).getId())) {
            UniversalDAO.deleteEntityById("ticket", id);
        }
    }

    public static void updateTicketByTicket(Ticket ticket) throws IOException {
        if (ticket.getId().equals(getTicketById(ticket.getId()).getId())) {
            UniversalDAO.updateEntity("ticket", ticket);
        }
    }

}
