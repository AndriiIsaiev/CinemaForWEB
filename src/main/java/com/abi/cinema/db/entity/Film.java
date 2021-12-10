package com.abi.cinema.db.entity;

import java.sql.Time;

public class Film extends Entity {
    private Integer id;
    private String title;
    private String year;
    private String studio;
    private Time length;
    private Integer ageCategory;
    private String description;
    private String photoURL;

    public Film() {
    }

    public Film(String title, String year, String studio, String length, Integer ageCategory, String description, String photoURL) {
        this.title = title;
        this.length = Time.valueOf(length);
        this.ageCategory = ageCategory;
        this.year = year;
        this.studio = studio;
        this.description = description;
        this.photoURL = photoURL;
    }

    public Film(Integer id, String title, String year, String studio, String length, Integer ageCategory, String description, String photoURL) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.studio = studio;
        System.out.println(length);
        this.length = Time.valueOf(length);
        this.ageCategory = ageCategory;
        this.description = description;
        this.photoURL = photoURL;
    }

    public Film(String title, String year, String studio) {
        this(title, year, studio,  "0:00:00", 0, "", "");
    }

    public Film(String title) { this(title, "0", "",  "0:00:00", 0, "", ""); }

    public Film(Film film) {
        id = film.id;
        title = film.title;
        year = film.year;
        studio = film.studio;
        length = film.length;
        ageCategory = film.ageCategory;
        description = film.description;
        photoURL = film.photoURL;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }
    public String getStudio() { return studio; }
    public void setStudio(String studio) { this.studio = studio; }
    public Time getLength() { return length; }
    public void setLength(String length) { this.length = Time.valueOf(length); }
    public Integer getAgeCategory() { return ageCategory; }
    public void setAgeCategory(Integer ageCategory) { this.ageCategory = ageCategory; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getPhotoURL() { return photoURL; }
    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!title.equals(((Film) o).title)) return false;
        if (year != null ? !year.equals(((Film) o).year) : ((Film) o).year != null) return false;
        return studio != null ? studio.equals(((Film) o).studio) : ((Film) o).studio == null;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (studio != null ? studio.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return id + " " + title + " " + year + " " + studio;
    }

    @Override
    public Film clone() {
        return new Film(this);
    }

}
