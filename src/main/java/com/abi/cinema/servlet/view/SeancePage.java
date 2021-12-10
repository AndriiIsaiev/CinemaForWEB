package com.abi.cinema.servlet.view;

import com.abi.cinema.db.entity.Genre;

import java.util.ArrayList;
import java.util.List;

public class SeancePage {
    private int pageNumber;
    private int pageMax;
    private int pageSize;
    private String pageSort;
    private int filmIdFilter;
    private int genreIdFilter;
    private List<Genre> listGenre;
    private int allSeance;


    public SeancePage() {
        pageNumber = 1;
        pageMax = 1;
        pageSize = 5;
        pageSort = "dateTime";
        filmIdFilter = -1;
        genreIdFilter = -1;
        listGenre = new ArrayList<>();
        allSeance = 0;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageMax() {
        return pageMax;
    }

    public void setPageMax(int pageMax) {
        this.pageMax = pageMax;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageSort() {
        return pageSort;
    }

    public void setPageSort(String pageSort) {
        this.pageSort = pageSort;
    }

    public int getFilmIdFilter() { return filmIdFilter; }

    public void setFilmIdFilter(int filmIdFilter) { this.filmIdFilter = filmIdFilter; }

    public int getGenreIdFilter() { return genreIdFilter; }

    public void setGenreIdFilter(int genreIdFilter) { this.genreIdFilter = genreIdFilter; }

    public List<Genre> getListGenre() { return listGenre; }

    public void setListGenre(List<Genre> listGenre) {
        this.listGenre.add(new Genre(-1, "все жанры"));
        this.listGenre.addAll(listGenre);
    }

    public long getAllSeance() {
        return allSeance;
    }

    public void setAllSeance(int allSeance) {
        this.allSeance = allSeance;
    }
}
