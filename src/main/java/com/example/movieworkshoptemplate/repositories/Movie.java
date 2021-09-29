package com.example.movieworkshoptemplate.repositories;

public class Movie implements Comparable<Movie> {
    //Year;Length;Title;Subject;Popularity;Awards
    //1963;138;8 1/2;Drama;80;Yes

    private final int year, length, popularity;
    private final String title, subject, awards;

    public Movie(int year, int length,  String title, String subject, int popularity, String awards) {
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        this.awards = awards;
    }

    public int getYear() {
        return year;
    }

    public int getLength() {
        return length;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public String isAwards() {
        return awards;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "year: " + year +
                ", length: " + length +
                ", popularity: " + popularity +
                ", title: '" + title + '\'' +
                ", subject: '" + subject + '\'' +
                ", awards: " + awards +
                '}';
    }

    @Override
    public int compareTo(Movie other) {
        return Integer.compare(this.popularity, other.popularity);
    }
}
