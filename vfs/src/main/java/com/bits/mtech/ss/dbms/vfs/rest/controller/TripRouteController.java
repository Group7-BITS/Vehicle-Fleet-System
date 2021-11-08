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
import com.bits.mtech.ss.dbms.vfs.entity.TripRoute;
import com.bits.mtech.ss.dbms.vfs.entity.repository.TripRouteRepository;

@RestController
public class TripRouteController {

	@Autowired
	private TripRouteRepository tripRouteRepository;
	
	@GetMapping("/tripRoute")
	public List<TripRoute> retrieveAllTripRoute() {
		return tripRouteRepository.findAll();
	}
	
	@GetMapping("/tripRoute/{id}")
	public TripRoute retrieveTripRoute(@PathVariable long id) {
		Optional<TripRoute> tripRoute = tripRouteRepository.findById(id);

		if (!tripRoute.isPresent())
			throw new VfsException(String.format("Not founnd id-%s" , id));

		return tripRoute.get();
	}
	
	@DeleteMapping("/tripRoute/{id}")
	public void deleteTripRoute(@PathVariable long id) {
		tripRouteRepository.deleteById(id);
	}
	
	
	@PostMapping("/tripRoute")
	public ResponseEntity<Object> createTripRoute(@RequestBody TripRoute tripRoute) {
		TripRoute savedTripRoute = tripRouteRepository.save(tripRoute);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedTripRoute.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/tripRoute/{id}")
	public ResponseEntity<Object> updateTripRoute(@RequestBody TripRoute tripRoute, @PathVariable long id) {

		Optional<TripRoute> tripRouteOptional = tripRouteRepository.findById(id);

		if (!tripRouteOptional.isPresent())
			return ResponseEntity.notFound().build();

		tripRoute.setId(id);
		
		tripRouteRepository.save(tripRoute);

		return ResponseEntity.noContent().build();
	}


}
