package com.abi.cinema.db.dao;

import com.abi.cinema.db.dao.Item;
import com.abi.cinema.db.dao.UniversalDAO;
import com.abi.cinema.db.entity.Entity;
import com.abi.cinema.db.entity.Film;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {

    public static void insertFilm(Film film) {
        if (getFilmByContent(film).size() == 0) {
            UniversalDAO.insertEntity("film", film);
        }
    }

    public static Film getFilmById(int id) {
        return ((Film) UniversalDAO.getEntityById("film", id, new Film()));
    }

    public static List<Film> getFilmByContent(Film film) {
        List<Item> filter = new ArrayList<>();
        filter.add(new Item("","title", "=", film.getTitle()));
        List<Film> listFilm = getFilmByFilter(filter);
        return listFilm;
    }

    public static List<Film> getFilmByFilter(List<Item> filter) {
        return FilmDAO.getFilmBySQL("", filter, "");
    }

    public static List<Film> getFilmBySQL(String joinCondition, List<Item> whereCondition, String postCondition) {
        List<Entity> listEntity = UniversalDAO.getEntityBySQL("film", joinCondition, whereCondition, postCondition, new Film());
        ArrayList<Film> listFilm = new ArrayList<>();
        for (Entity en : listEntity) {
            listFilm.add((Film) en);
        }
        return listFilm;
    }

    public static List<Film> getAllFilm() {
        return getFilmByFilter(new ArrayList<>());
    }

    public static void deleteFilmById(int id) {
        if (((Integer) id).equals(getFilmById(id).getId())) {
            UniversalDAO.deleteEntityById("film", id);
        }
    }

    public static void updateFilmByFilm(Film film) {
        if (film.getId().equals(getFilmById(film.getId()).getId())) {
            UniversalDAO.updateEntity("film", film);
        }
    }


}
