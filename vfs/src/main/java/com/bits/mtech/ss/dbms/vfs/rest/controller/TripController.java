package com.bits.mtech.ss.dbms.vfs.rest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bits.mtech.ss.dbms.vfs.VfsException;
import com.bits.mtech.ss.dbms.vfs.entity.Trip;
import com.bits.mtech.ss.dbms.vfs.entity.repository.TripRepository;

@RestController
public class TripController {

	@Autowired
	private TripRepository tripRepository;
	
	@GetMapping("/trip")
	public List<Trip> retrieveAllTrip() {
		return tripRepository.findAll();
	}
	
	@GetMapping("/trip/{id}")
	public Trip retrieveTrip(@PathVariable long id) {
		Optional<Trip> trip = tripRepository.findById(id);

		if (!trip.isPresent())
			throw new VfsException(String.format("Not founnd id-%s" , id));

		return trip.get();
	}
	
	@DeleteMapping("/trip/{id}")
	public void deleteTrip(@PathVariable long id) {
		tripRepository.deleteById(id);
	}
	
	
	@PostMapping("/trip")
	public ResponseEntity<Object> createTrip(@RequestBody Trip trip) {
		Trip savedTrip = tripRepository.save(trip);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedTrip.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/trip/{id}")
	public ResponseEntity<Object> updateTrip(@RequestBody Trip trip, @PathVariable long id) {

		Optional<Trip> tripOptional = tripRepository.findById(id);

		if (!tripOptional.isPresent())
			return ResponseEntity.notFound().build();

		trip.setId(id);
		
		tripRepository.save(trip);

		return ResponseEntity.noContent().build();
	}


}
