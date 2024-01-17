package com.example.demo.db;

import com.example.demo.business.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepo extends CrudRepository<Movie, Integer> {
    List<Movie> findAllByRating(String rating);
    // find movies released since year
    List<Movie> findAllByYearGreaterThanEqual(int year);
}
