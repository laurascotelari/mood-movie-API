package com.laurascot.moviesAPI.entitys;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false)
    private int releaseYear;

    @ElementCollection
    @Column(nullable = false)
    private List<String> mood;

    protected Movie() {}

    //Class constructor
    public Movie(String name, int releaseYear, List<String> mood) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.mood = mood;
    }

    //Getters and Setters
    public long getId() {
        return this.Id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return this.releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<String> getMood() {
        return this.mood;
    }

    public void setMood(List<String> mood) {
        this.mood = mood;
    }

    //To String Method
    @Override
    public String toString() {
        return "{" +
            " Id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", releaseYear='" + getReleaseYear() + "'" +
            ", mood='" + getMood() + "'" +
            "}";
    }



}
