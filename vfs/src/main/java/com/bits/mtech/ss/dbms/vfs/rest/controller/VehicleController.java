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
import com.bits.mtech.ss.dbms.vfs.entity.Vehicle;
import com.bits.mtech.ss.dbms.vfs.entity.repository.VehicleRepository;

@RestController
public class VehicleController {
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@GetMapping("/vehicles")
	public List<Vehicle> retrieveAllVehicles() {
		return vehicleRepository.findAll();
	}
	
	@GetMapping("/vehicles/{id}")
	public Vehicle retrieveVehicle(@PathVariable long id) {
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);

		if (!vehicle.isPresent())
			throw new VfsException(String.format("Not founnd id-%s" , id));

		return vehicle.get();
	}
	
	@DeleteMapping("/vehicles/{id}")
	public void deleteVehicle(@PathVariable long id) {
		vehicleRepository.deleteById(id);
	}
	
	
	@PostMapping("/vehicles")
	public ResponseEntity<Object> createVehicle(@RequestBody Vehicle vehicle) {
		Vehicle savedVehicle = vehicleRepository.save(vehicle);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedVehicle.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/vehicles/{id}")
	public ResponseEntity<Object> updateVehicle(@RequestBody Vehicle vehicle, @PathVariable long id) {

		Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);

		if (!vehicleOptional.isPresent())
			return ResponseEntity.notFound().build();

		vehicle.setId(id);
		
		vehicleRepository.save(vehicle);

		return ResponseEntity.noContent().build();
	}
}
