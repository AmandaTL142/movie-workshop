package com.example.movieworkshoptemplate.repositories;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile{
    public ArrayList<Movie> fileReader() throws FileNotFoundException{
        File movies = new File("resources/imdb-data.csv");

        Scanner readmovie = new Scanner(movies);

        //Skips metadata
        readmovie.nextLine();

        ArrayList<Movie> moviesList = new ArrayList<>();

        while (readmovie.hasNext()) {

            String currentMovie = readmovie.nextLine();

            String[] lineAsArray = currentMovie.split(";");
            int year = Integer.parseInt(lineAsArray[0]);
            int length = Integer.parseInt(lineAsArray[1]);
            String title = lineAsArray[2];
            String subject = lineAsArray[3];
            int popularity = Integer.parseInt(lineAsArray[4]);
            String awards = lineAsArray[5];

            Movie newMovie = new Movie(year, length, title, subject, popularity, awards);
            moviesList.add(newMovie);

            //System.out.println(newMovie)
        }

        return moviesList;
    }
}
