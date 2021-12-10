package com.abi.cinema.db.dao;

import com.abi.cinema.db.entity.Genre;
import com.abi.cinema.db.relation.FilmGenre;
import com.abi.cinema.db.relation.Relation;

import java.util.ArrayList;
import java.util.List;

public class FilmGenreDAO {

    public static void insertFilmGenre(FilmGenre filmGenre) {
        if (getFilmGenreByRelation(filmGenre).size() == 0) {
            UniversalDAO.insertRelation("film_genre", filmGenre);
        }
    }

    public static List<FilmGenre> getFilmGenreByRelation(FilmGenre filmGenre) {
        List<Item> filter = new ArrayList<>();
        filter.add(new Item("","filmId", "=", filmGenre.getFilmId()));
        filter.add(new Item("AND","genreId", "=", filmGenre.getGenreId()));
        List<FilmGenre> listFilmGenre = getFilmGenreByFilter(filter);
        return listFilmGenre;
    }

    public static List<FilmGenre> getFilmGenreByFilter(List<Item> filter) {
        List<Relation> listRelation = UniversalDAO.getRelationByFilter("film_genre", filter, new FilmGenre());
        ArrayList<FilmGenre> listFilmGenre = new ArrayList<>();
        for (Object ob : listRelation) {
            listFilmGenre.add((FilmGenre) ob);
        }
        return listFilmGenre;
    }

    public static List<Genre> getFilmGenreByFilmId(Integer filmId) {
        List<Item> filter = new ArrayList<>();
        filter.add(new Item("","filmId", "=", filmId));
        List<Relation> listRelation = UniversalDAO.getRelationByFilter("film_genre", filter, new FilmGenre());
        ArrayList<Genre> listGenre = new ArrayList<>();
        for (Object ob : listRelation) {
            listGenre.add(GenreDAO.getGenreById(((FilmGenre) ob).getGenreId()));
        }
        return listGenre;
    }

//    public static List<Genre> getAllGenre() {
//        return FilmGenreDAO.getGenreByFilter(new ArrayList<>());
//    }
//
//    public static void deleteGenreById(int id) {
//        if (((Integer) id).equals(getGenreById(id).getId())) {
//            UniversalDAO.deleteEntityById("genre", id);
//        }
//    }
//
//    public static void updateGenreByGenre(Genre genre) {
//        if (genre.getId().equals(getGenreById(genre.getId()).getId())) {
//            UniversalDAO.updateEntity("genre", genre);
//        }
//    }

}
