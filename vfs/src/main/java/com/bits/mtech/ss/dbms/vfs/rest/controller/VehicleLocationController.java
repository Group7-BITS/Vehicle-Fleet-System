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
import com.bits.mtech.ss.dbms.vfs.entity.VehicleLocation;
import com.bits.mtech.ss.dbms.vfs.entity.repository.VehicleLocationRepository;

@RestController
public class VehicleLocationController {
	@Autowired
	private VehicleLocationRepository vehicleLocationRepository;
	
	@GetMapping("/vehicleLocations")
	public List<VehicleLocation> retrieveAllVehicleLocations() {
		return vehicleLocationRepository.findAll();
	}
	
	@GetMapping("/vehicleLocations/{id}")
	public VehicleLocation retrieveVehicleLocation(@PathVariable long id) {
		Optional<VehicleLocation> vehicleLocation = vehicleLocationRepository.findById(id);

		if (!vehicleLocation.isPresent())
			throw new VfsException(String.format("Not founnd id-%s" , id));

		return vehicleLocation.get();
	}
	
	@DeleteMapping("/vehicleLocations/{id}")
	public void deleteVehicleLocation(@PathVariable long id) {
		vehicleLocationRepository.deleteById(id);
	}
	
	
	@PostMapping("/vehicleLocations")
	public ResponseEntity<Object> createVehicleLocation(@RequestBody VehicleLocation vehicleLocation) {
		VehicleLocation savedVehicleLocation = vehicleLocationRepository.save(vehicleLocation);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedVehicleLocation.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/vehicleLocations/{id}")
	public ResponseEntity<Object> updateVehicleLocation(@RequestBody VehicleLocation vehicleLocation, @PathVariable long id) {

		Optional<VehicleLocation> vehicleLocationOptional = vehicleLocationRepository.findById(id);

		if (!vehicleLocationOptional.isPresent())
			return ResponseEntity.notFound().build();

		vehicleLocation.setId(id);
		
		vehicleLocationRepository.save(vehicleLocation);

		return ResponseEntity.noContent().build();
	}
	


}
