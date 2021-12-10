package com.abi.cinema.db.entity;

public class Genre extends Entity{
    private Integer id;
    private String name;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public Genre(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Genre(Genre genre){
        id = genre.id;
        name = genre.name;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return name.equals(((Genre) o).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() { return id + " " + name;
    }

    @Override
    public Genre clone() {
        return new Genre(this);
    }

}
