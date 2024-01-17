package com.example.demo.db;

import java.util.Optional;

import com.example.demo.business.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepo extends CrudRepository<Actor, Integer> {

	// find actor by firstname, lastname
	Optional<Actor> findByFirstNameAndLastName(String firstName, String lastName);
}
