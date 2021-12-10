package com.abi.cinema.db.relation;

import java.sql.Timestamp;

public class UserFilm extends Relation {
    private Integer userId;
    private Integer filmId;
    private Timestamp viewTime;
    private Integer score;
    private String review;

    public UserFilm() {
    }

    public UserFilm(UserFilm userFilm) {
        userId = userFilm.userId;
        filmId = userFilm.filmId;
        viewTime = userFilm.viewTime;
        score = userFilm.score;
        review = userFilm.review;
    }

    public UserFilm(Integer userId, Integer filmId, Timestamp viewTime, Integer score, String review) {
        this.userId = userId;
        this.filmId = filmId;
        this.viewTime = viewTime;
        this.score = score;
        this.review = review;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Timestamp getViewTime() {
        return viewTime;
    }

    public void setViewTime(Timestamp viewTime) {
        this.viewTime = viewTime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public UserFilm clone() {
        return new UserFilm(this);
    }

}
