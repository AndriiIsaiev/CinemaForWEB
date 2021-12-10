package com.abi.cinema.servlet.view;

import com.abi.cinema.db.entity.Film;
import com.abi.cinema.db.entity.Genre;

import java.util.List;

public class FilmPageItem {
    private Film film;
    private List<Genre> listGenre;

    public FilmPageItem() {
    }

    public FilmPageItem(Film film, List<Genre> listGenre) {
        this.film = film;
        this.listGenre = listGenre;
    }

    public Film getFilm() { return film; }

    public void setFilm(Film film) { this.film = film; }

    public List<Genre> getListGenre() { return listGenre; }

    public void setListGenre(List<Genre> listGenre) { this.listGenre = listGenre; }

}
