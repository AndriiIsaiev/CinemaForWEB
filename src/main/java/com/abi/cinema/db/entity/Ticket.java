package com.abi.cinema.db.entity;

import java.sql.Timestamp;

public class Ticket extends Entity implements Comparable<Ticket>{
    private Integer id;
    private Integer seanceId;
    private Timestamp dateTime;
    private String filmName;
    private Float cost;
    private Integer userId;
    private Integer seatId;
    private Timestamp buyTime;
    private Integer status;

    public Ticket() {
    }

    public Ticket(Integer seanceId, Timestamp dateTime, String filmName, Float cost, Integer userId, Integer seatId, Timestamp buyTime, Integer status) {
        this.seanceId = seanceId;
        this.dateTime = dateTime;
        this.filmName = filmName;
        this.cost = cost;
        this.userId = userId;
        this.seatId = seatId;
        this.buyTime = buyTime;
        this.status = status;
    }

    public Ticket(Integer seanceId, Timestamp dateTime, String filmName, Float cost, Integer userId, Integer seatId, String buyTime, Integer status) {
        this.seanceId = seanceId;
        this.dateTime = dateTime;
        this.filmName = filmName;
        this.cost = cost;
        this.userId = userId;
        this.seatId = seatId;
        this.buyTime = Timestamp.valueOf(buyTime);
        this.status = status;
    }

    public Ticket(Ticket ticket) {
        id = ticket.id;
        seanceId = ticket.seanceId;
        dateTime = ticket.dateTime;
        filmName = ticket.filmName;
        cost = ticket.cost;
        userId = ticket.userId;
        seatId = ticket.seatId;
        buyTime = ticket.buyTime;
        status = ticket.status;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getSeanceId() {
        return seanceId;
    }
    public void setSeanceId(Integer seanceId) {
        this.seanceId = seanceId;
    }
    public Timestamp getDateTime() {
        return dateTime;
    }
    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }
    public String getFilmName() {
        return filmName;
    }
    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }
    public Float getCost() {
        return cost;
    }
    public void setCost(Float cost) {
        this.cost = cost;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getSeatId() {
        return seatId;
    }
    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }
    public Timestamp getBuyTime() {
        return buyTime;
    }
    public void setBuyTime(Timestamp buyTime) {
        this.buyTime = buyTime;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (!seanceId.equals(ticket.seanceId)) return false;
        return seatId.equals(ticket.seatId);
    }

    @Override
    public int hashCode() {
        int result = seanceId.hashCode();
        result = 31 * result + seatId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", seanceId=" + seanceId +
                ", dateTime=" + dateTime +
                ", filmName=" + filmName +
                ", cost=" + cost +
                ", userId=" + userId +
                ", seatId=" + seatId +
                ", buyTime=" + buyTime +
                ", status=" + status +
                '}';
    }

    @Override
    public Ticket clone() {
        return new Ticket(this);
    }

    @Override
    public int compareTo(Ticket ticket) {
        String thisTicket = String.format("%05d", seanceId) + String.format("%03d", seatId);
        String anotherTicket = String.format("%05d", ticket.seanceId) + String.format("%03d", ticket.seatId);
        return thisTicket.compareTo(anotherTicket);
    }
}
