package com.abi.cinema.db.dao;

import com.abi.cinema.db.entity.Entity;
import com.abi.cinema.db.entity.Seance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeanceDAO {

    public static void insertSeance(Seance seance) throws IOException {
        UniversalDAO.insertEntity("seance", seance);
    }

    public static Seance getSeanceById(int id) throws IOException {
        return ((Seance) UniversalDAO.getEntityById("seance", id, new Seance()));
    }

    public static List<Seance> getSeanceByFilter(List<Item> filter) throws IOException {
        return SeanceDAO.getSeanceBySQL("", filter, "");
    }

    public static List<Seance> getSeanceBySQL(String joinCondition, List<Item> whereCondition, String postCondition) throws IOException {
        List<Entity> listEntity = UniversalDAO.getEntityBySQL("seance", joinCondition, whereCondition, postCondition, new Seance());
        ArrayList<Seance> listSeance = new ArrayList<>();
        for (Entity en : listEntity) {
            listSeance.add((Seance) en);
        }
        return listSeance;
    }

    public static List<Seance> getAllSeance() throws IOException {
        return getSeanceByFilter(new ArrayList<>());
    }

}