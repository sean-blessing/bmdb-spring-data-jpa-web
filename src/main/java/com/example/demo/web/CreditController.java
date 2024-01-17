package com.example.demo.web;

import java.util.Optional;

import com.example.demo.business.Credit;
import com.example.demo.db.CreditRepo;
import com.example.demo.db.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/credits")
public class CreditController {
	
	@Autowired
	private CreditRepo creditRepo;
	@Autowired
	private MovieRepo movieRepo;

	@GetMapping("/")
	public Iterable<Credit> getAll() {
		return creditRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Credit> get(@PathVariable Integer id) {
		return creditRepo.findById(id);
	}
	
	@PostMapping("/")
	public Credit add(@RequestBody Credit credit) {
		return creditRepo.save(credit);
	}
	
	@PutMapping("/")
	public Credit update(@RequestBody Credit credit) {
		return creditRepo.save(credit);
	}

	@DeleteMapping("/{id}")
	public Optional<Credit> delete(@PathVariable int id) {
		creditRepo.deleteById(id);
		Optional<Credit> credit = creditRepo.findById(id);
		if (credit.isPresent()) {
			creditRepo.deleteById(id);
		}
		return credit;
	}
	
	// custom queries
	@GetMapping("/movie/{id}")
	public Iterable<Credit> getAllByMovie(@PathVariable int id) {
		//Optional<Movie> movie = movieRepo.findById(id);
		return creditRepo.findAllByMovieId(id);
	}
	
	
	
	
	
	
	
	
	
	

}
