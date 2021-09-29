package com.example.movieworkshoptemplate.controllers;

import com.example.movieworkshoptemplate.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class MovieController{
    //Controller methods
    MovieService movieService = new MovieService();
    public MovieController() throws FileNotFoundException {
    }

    //Task 3.1:
    @GetMapping("/")
    public String index(){
        return "Hello human, this application gives you facts about movies - if you know where to look!";
    }

    //Task 3.2:
    @GetMapping("/getFirstMovie")
    public String getFirst() {
        return movieService.getFirstMovie();
    }

    //Task 3.3:
    @GetMapping("/getRandomMovie")
    public String getRandomMovie() {
        return movieService.getRandomMovie();
    }

    //Task 3.4:
    @GetMapping("/getTenSortByPopularity")
    public String getTenSortByPopularity() {
        return movieService.getTenSortByPopularity();
    }

    //Task 3.5:
    @GetMapping("/howManyWonAnAward")
    public int howManyWonAnAward() {
        return movieService.howManyWonAnAward();
    }


    // Task 3.6
    ///filter?char=’x’amount=’n’
    // Eksempel: http://localhost:8080/filter?char=a&amount=1
    @GetMapping("/filter")
    public String filterMovies(@RequestParam("char") char c, @RequestParam("amount") int n) {
        return movieService.filterMovies(c,n);
    }


    //Task 3.7:
    // Eksempel: http://localhost:8080/longest?g1=Drama&g2=Comedy
    @GetMapping("/longest")
    public String compareGenreLength(@RequestParam("g1") String g1, @RequestParam("g2") String g2) {
        return movieService.compareGenreLength(g1, g2);
    }

}
