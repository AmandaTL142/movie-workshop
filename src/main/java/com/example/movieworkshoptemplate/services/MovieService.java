package com.example.movieworkshoptemplate.services;

import com.example.movieworkshoptemplate.repositories.Movie;
import com.example.movieworkshoptemplate.repositories.ReadFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class MovieService {
    //Services called from controllers that returns what the client requests
    ReadFile reader = new ReadFile();
    ArrayList<Movie> moviesList = reader.fileReader();

    public MovieService() throws FileNotFoundException {
    }

    /*
    3.2 /getFirst
    Shown in class This end-points calls a service that finds the first movie from the list and displays the title.
     */
    public String getFirstMovie() {
        return moviesList.get(0).getTitle();
    }

    /*
    3.3 /getRandom
    This end-point calls a service, that finds a single random movie from the list and displays the title.
     */
    public String getRandomMovie() {
        double currentNumber = Math.floor(Math.random()*(moviesList.size()-1)+1);
        return moviesList.get((int) currentNumber).getTitle();
    }

    /*
    3.4 /getTenSortByPopularity
        This end-point calls a service that fetches 10 random movies, maps each result to a Movie model class, adds to a
        Movie Arraylist and prints the result to the browser - sorted in ascending order by popularity
        (Hint: Remember the comparable interface).
     */

    public String getTenSortByPopularity() {

        HashSet<Movie> tenRandomMovies = new HashSet<>();

        while(tenRandomMovies.size() < 10) {
            double currentNumber = Math.floor(Math.random()*(moviesList.size()-1)+1);
            tenRandomMovies.add(moviesList.get((int) currentNumber));
        }

        ArrayList<Movie> sortedTenMovies = new ArrayList<>(tenRandomMovies);

        Collections.sort(sortedTenMovies);

        StringBuilder result = new StringBuilder("Movies:<br>");
        for (Movie movie: sortedTenMovies) {
            result.append(movie.getTitle()).append("; popularity: ").append(movie.getPopularity()).append("<br>");

        }

        return result.toString();
    }


    /*
    3.5  /howManyWonAnAward This  end-point  prints  how  many  of
    the  movies  of  the  data-set  that  won  an award.
    */
    public int howManyWonAnAward() {
        int awardCount = 0;
        for (Movie movie:moviesList) {
            if (movie.isAwards().equalsIgnoreCase("yes")){
                awardCount ++;
            }
        }
        return awardCount;
    }

    /*
    3.6 (Advanced) /filter?char=’x’amount=’n’ - Amanda
    This end points calls a service that prints all movies, but only if they contain x character n amount of times
     */
    public String filterMovies(char c, int n){
        StringBuilder result = new StringBuilder("Movies with " + n + " instances of " + "'" + c + "' in title:<br>");
        for (Movie movie: moviesList) {
            String title = movie.getTitle();
            long count = title.chars().filter(ch -> ch == c).count();
            if (count == n){
                result.append(title).append("<br>");
            }
        }
        return result.toString();
    }

    /*
    3.7 (Advanced) /longest?g1=’x’g2=’y’ - Amanda
    This end-point calls a service that compares two genres and finds what genre, on average, has the longest movies.
     */

    public String compareGenreLength(String genre1, String genre2){
        int countNoMoviesG1 = 0;
        int countTotalLengthG1 = 0;
        int countNoMoviesG2 = 0;
        int countTotalLengthG2 = 0;
        for (Movie movie: moviesList) {

            if (movie.getSubject().equalsIgnoreCase(genre1)){
                countNoMoviesG1 ++;
                countTotalLengthG1 += movie.getLength();
            } else if (movie.getSubject().equalsIgnoreCase(genre2)){
                countNoMoviesG2 ++;
                countTotalLengthG2 += movie.getLength();
            }
        }
        int avLengthG1 = countTotalLengthG1/countNoMoviesG1;
        int avLengthG2 = countTotalLengthG2/countNoMoviesG2;

        if (avLengthG1 > avLengthG2){
            return "The genre " + genre1 + " has movies of an average longer length than " + genre2;
        } else if (avLengthG1 < avLengthG2) {
            return "The genre '" + genre2 + "' has movies of an average longer length than the genre '" + genre1 + "'.";
        } else {
            return genre1 + " and " + genre2 + " have movies of an equal average length.";
        }
    }


}
