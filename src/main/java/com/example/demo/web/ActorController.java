package com.example.demo.web;

import java.util.Optional;

import com.example.demo.business.Actor;
import com.example.demo.db.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/actors")
public class ActorController {
	
	@Autowired
	private ActorRepo actorRepo;

	@GetMapping("/")
	public Iterable<Actor> getAll() {
		return actorRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Actor> get(@PathVariable Integer id) {
		return actorRepo.findById(id);
	}
	
	@PostMapping("/")
	public Actor add(@RequestBody Actor actor) {
		return actorRepo.save(actor);
	}
	
	@PutMapping("/")
	public Actor update(@RequestBody Actor actor) {
		return actorRepo.save(actor);
	}

	@DeleteMapping("/{id}")
	public Optional<Actor> delete(@PathVariable int id) {
		actorRepo.deleteById(id);
		Optional<Actor> actor = actorRepo.findById(id);
		if (actor.isPresent()) {
			actorRepo.deleteById(id);
		}
		else {
			System.err.println("Error deleting actor");
		}
		return actor;
	}
	
	// custom queries
	@GetMapping("/name")
	public Optional<Actor> get(@RequestParam String firstName, @RequestParam String lastName) {
		return actorRepo.findByFirstNameAndLastName(firstName, lastName);
	}


}
