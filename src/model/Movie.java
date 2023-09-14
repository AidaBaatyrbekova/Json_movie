package model;

// TODO: 13.09.2023 у вас есть класс Movie у него должен быть следующие поля
//  id,name,genre(enum),createDate(LocalDate),касса

import model.enums.Genre;

import java.time.LocalDateTime;

public class Movie {
    private int id;
    private String name;
    private Genre genre;
    private LocalDateTime createDate;
    private String cashBox;

    public Movie() {
    }

    public Movie(int id, String name, Genre genre, LocalDateTime createDate, String cashBox) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.createDate = createDate;
        this.cashBox = cashBox;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getCashBox() {
        return cashBox;
    }

    public void setCashBox(String cashBox) {
        this.cashBox = cashBox;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", createDate=" + createDate +
                ", cashBox='" + cashBox + '\'' +
                '}' + "\n";
    }
}
