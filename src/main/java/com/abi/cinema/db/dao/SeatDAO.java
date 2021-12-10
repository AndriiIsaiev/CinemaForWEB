package com.abi.cinema.db.dao;

import com.abi.cinema.db.entity.Entity;
import com.abi.cinema.db.entity.Seat;
import java.util.ArrayList;
import java.util.List;

public class SeatDAO {
    public static final int MAX_LINE = 5;
    public static final int MAX_POSITION = 6;

    public static void insertSeat(Seat seat){
        if (getSeatByContent(seat).size() == 0) {
            UniversalDAO.insertEntity("seat", seat);
        }
    }

    public static Seat getSeatById(int id) {
        return ((Seat) UniversalDAO.getEntityById("seat", id, new Seat()));
    }

    public static List<Seat> getSeatByContent(Seat seat) {
        List<Item> filter = new ArrayList<>();
        filter.add(new Item("AND","line", "=", seat.getLine()));
        filter.add(new Item("AND","Position", "=", seat.getPosition()));
        List<Seat> listSeat = getSeatByFilter(filter);
        return listSeat;
    }

    public static List<Seat> getSeatByFilter(List<Item> filter) {
        return SeatDAO.getSeatBySQL("", filter, "");
    }

    public static List<Seat> getSeatBySQL(String joinCondition, List<Item> whereCondition, String postCondition) {
        List<Entity> listEntity = UniversalDAO.getEntityBySQL("seat", joinCondition, whereCondition, postCondition, new Seat());
        ArrayList<Seat> listSeat = new ArrayList<>();
        for (Entity en : listEntity) {
            listSeat.add((Seat) en);
        }
        return listSeat;
    }

    public static List<Seat> getAllSeat() {
        return getSeatByFilter(new ArrayList<>());
    }

    public static void deleteSeatById(int id) {
        if (((Integer) id).equals(getSeatById(id).getId())) {
            UniversalDAO.deleteEntityById("seat", id);
        }
    }

}