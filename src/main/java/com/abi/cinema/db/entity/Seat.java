package com.abi.cinema.db.entity;

public class Seat extends Entity{
    private Integer id;
    private Integer line;
    private Integer position;

    public Seat() {
    }

    public Seat(Integer line, Integer position) {
        this.line = line;
        this.position = position;
    }

    public Seat(Seat seat) {
        id = seat.id;
        line = seat.line;
        position = seat.position;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getLine() {
        return line;
    }
    public void setLine(Integer line) {
        this.line = line;
    }
    public Integer getPosition() {
        return position;
    }
    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!line.equals(((Seat) o).line)) return false;
        return position.equals(((Seat) o).position);
    }

    @Override
    public int hashCode() {
        int result = line.hashCode();
        result = 31 * result + position.hashCode();
        return result;
    }

    @Override
    public String toString() { return id + " " + line + " " + position; }

    @Override
    public Seat clone() {
        return new Seat(this);
    }

}
