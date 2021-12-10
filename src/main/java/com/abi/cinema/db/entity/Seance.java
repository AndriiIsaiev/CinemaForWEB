package com.abi.cinema.db.entity;

import java.sql.Timestamp;

public class Seance extends Entity{
    private Integer id;
    private Integer filmId;
    private Timestamp dateTime;
    private Float baseCost;

    public Seance() {
    }

    public Seance(Integer filmId, Timestamp dateTime, Float base_cost) {
        this.filmId = filmId;
        this.dateTime = dateTime;
        this.baseCost = base_cost;
    }

    public Seance(Integer filmId, String dateTime, Float base_cost) {
        this.filmId = filmId;
        this.dateTime = Timestamp.valueOf(dateTime);
        this.baseCost = base_cost;
    }

    public Seance(Seance seance) {
        id = seance.id;
        filmId = seance.filmId;
        dateTime = seance.dateTime;
        baseCost = seance.baseCost;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getFilmId() { return filmId; }
    public void setFilmId(Integer filmId) { this.filmId = filmId; }
    public Timestamp getDateTime() { return dateTime; }
    public void setDateTime(Timestamp dateTime) { this.dateTime = dateTime; }
    public void setDateTime(String dateTime) { this.dateTime = Timestamp.valueOf(dateTime); }
    public Float getBaseCost() { return baseCost; }
    public void setBaseCost(Float baseCost) { this.baseCost = baseCost; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!filmId.equals(((Seance) o).filmId)) return false;
        return dateTime.equals(((Seance) o).dateTime);
    }

    @Override
    public int hashCode() {
        int result = filmId.hashCode();
        result = 31 * result + dateTime.hashCode();
        return result;
    }

    @Override
    public String toString() { return id + " " + filmId + " " + dateTime + " " + baseCost; }

    @Override
    public Seance clone() {
        return new Seance(this);
    }

}
