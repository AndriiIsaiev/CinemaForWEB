package com.abi.cinema.db.relation;

public class FilmGenre extends Relation {
    private Integer filmId;
    private Integer genreId;

    public FilmGenre() {
    }

    public FilmGenre(FilmGenre filmGenre) {
        filmId = filmGenre.filmId;
        genreId = filmGenre.genreId;
    }

    public FilmGenre(Integer filmId, Integer genreId) {
        this.filmId = filmId;
        this.genreId = genreId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    @Override
    public FilmGenre clone() {
        return new FilmGenre(this);
    }

}
