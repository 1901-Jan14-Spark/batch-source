package com.Comparable;

public class TV_Show implements Comparable <TV_Show> {

    private String title;
    private String creator;
    private int epNumber;
    private double rating;

    public TV_Show(String title, String creator, int epNumber, double rating) {
        this.title = title;
        this.creator = creator;
        this.epNumber = epNumber;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }

    public int getEpNumber() {
        return epNumber;
    }


    public double getRating() {
        return rating;
    }

    @Override
    public int compareTo(TV_Show s) {
        return this.epNumber - s.epNumber;
    }


}
