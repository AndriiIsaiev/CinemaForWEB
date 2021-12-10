package com.abi.cinema.servlet.view;

import com.abi.cinema.db.entity.Genre;

import java.sql.Timestamp;
import java.util.List;

public class SeancePageItem {
    private int seanceId;
    private String seanceDateTime;
    private String filmTitle;
    private String filmPhoto;
    private List<Genre> genre;
    private int freeSeat;
    private float cost;
    private boolean afterNow;


    public SeancePageItem() {
    }

    public SeancePageItem(int seanceId, String seanceDateTime, String filmTitle, String filmPhoto, List<Genre> genre, int freeSeat, float cost, boolean afterNow) {
        this.seanceId = seanceId;
        this.seanceDateTime = seanceDateTime;
        this.filmTitle = filmTitle;
        this.filmPhoto = filmPhoto;
        this.genre = genre;
        this.freeSeat = freeSeat;
        this.cost = cost;
        this.afterNow = afterNow;
    }

    public int getSeanceId() { return seanceId; }

    public void setSeanceId(int seanceId) {
        this.seanceId = seanceId;
    }

    public String getSeanceDateTime() {
        return seanceDateTime;
    }

    public void setSeanceDateTime(String seanceDateTime) {
        this.seanceDateTime = seanceDateTime;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getFilmPhoto() {
        return filmPhoto;
    }

    public List<Genre> getGenre() { return genre; }

    public void setGenre(List<Genre> genre) { this.genre = genre; }

    public void setFilmPhoto(String filmPhoto) {
        this.filmPhoto = filmPhoto;
    }

    public int getFreeSeat() {
        return freeSeat;
    }

    public void setFreeSeat(int freeSeat) {
        this.freeSeat = freeSeat;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean getAfterNow() {
        return afterNow;
    }

    public void setAfterNow(boolean afterNow) {
        this.afterNow = afterNow;
    }

}
