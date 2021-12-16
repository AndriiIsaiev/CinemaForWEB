package com.abi.cinema.db.dao;

import com.abi.cinema.db.entity.Seance;
import com.abi.cinema.db.entity.Ticket;
import com.abi.cinema.db.entity.User;

import java.util.*;

public class ReservePool {
    public static Set<Ticket> reservePool = new TreeSet<>();
    public static long lastCleaningTime = new Date().getTime();

    public ReservePool() {
    }

    public static synchronized boolean addToReservePool(Ticket ticket) {
//        if ( ! isInReservePool(ticket)) {
//            return false;
//        }
        return reservePool.add(ticket);
    }

    public static boolean removeFromReservePool(Ticket ticket) {
        if ( ! isInReservePool(ticket)) {
            return false;
        }
        return reservePool.remove(ticket);
    }

    public static synchronized void cleanPoll() {
        long newCleaningTime = new Date().getTime();
        if (newCleaningTime - lastCleaningTime > 60000) {
            lastCleaningTime = newCleaningTime;
            List<Ticket> ticketForDelete = new ArrayList<>();
            for (Ticket ticket : reservePool) {
                if (newCleaningTime - ticket.getBuyTime().getTime() > 120000) {
                    ticketForDelete.add(ticket);
                }
            }
            for (Ticket ticket : ticketForDelete) {
                removeFromReservePool(ticket);
            }
        }
    }


    public static boolean isInReservePool(Ticket ticket) {
        return reservePool.contains(ticket);
    }

    public static List<Ticket> getTicketBySeance(Seance seance) {
        List<Ticket> listTicket = new ArrayList<>();
        for (Ticket t : reservePool) {
            if (t.getSeanceId().equals(seance.getId())) {
                listTicket.add(t);
            }
        }
        return listTicket;
    }

    public static List<Ticket> getTicketByUser(User user) {
        List<Ticket> listTicket = new ArrayList<>();
        for (Ticket t : reservePool) {
            if (t.getUserId().equals(user.getId())) {
                listTicket.add(t);
            }
        }
        return listTicket;
    }

}
