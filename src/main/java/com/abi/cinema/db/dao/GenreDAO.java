package com.abi.cinema.db.dao;

import com.abi.cinema.db.entity.Entity;
import com.abi.cinema.db.entity.Genre;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {

    public static void insertGenre(Genre genre) throws IOException {
        if (getGenreByContent(genre).size() == 0) {
            UniversalDAO.insertEntity("genre", genre);
        }
    }

    public static Genre getGenreById(int id) throws IOException {
        return ((Genre) UniversalDAO.getEntityById("genre", id, new Genre()));
    }

    public static List<Genre> getGenreByContent(Genre genre) throws IOException {
        List<Item> filter = new ArrayList<>();
        filter.add(new Item("","name", "=", genre.getName()));
        List<Genre> listGenre = getGenreByFilter(filter);
        return listGenre;
    }

    public static List<Genre> getGenreByFilter(List<Item> filter) throws IOException {
        return GenreDAO.getGenreBySQL("", filter, "");
    }

    public static List<Genre> getGenreBySQL(String joinCondition, List<Item> whereCondition, String postCondition) throws IOException {
        List<Entity> listEntity = UniversalDAO.getEntityBySQL("genre", joinCondition, whereCondition, postCondition, new Genre());
        ArrayList<Genre> listGenre = new ArrayList<>();
        for (Entity en : listEntity) {
            listGenre.add((Genre) en);
        }
        return listGenre;
    }

    public static List<Genre> getAllGenre() throws IOException {
        return GenreDAO.getGenreByFilter(new ArrayList<>());
    }

    public static void deleteGenreById(int id) throws IOException {
        if (((Integer) id).equals(getGenreById(id).getId())) {
            UniversalDAO.deleteEntityById("genre", id);
        }
    }

    public static void updateGenreByGenre(Genre genre) throws IOException {
        if (genre.getId().equals(getGenreById(genre.getId()).getId())) {
            UniversalDAO.updateEntity("genre", genre);
        }
    }

}
