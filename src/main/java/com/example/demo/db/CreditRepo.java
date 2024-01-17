package com.example.demo.db;


import com.example.demo.business.Credit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CreditRepo extends CrudRepository<Credit, Integer> {
	
	// get all credits by movie
	List<Credit> findAllByMovieId(int id);
	//List<Credit> findAllByMovie(Movie movie);  <- this also works
}
