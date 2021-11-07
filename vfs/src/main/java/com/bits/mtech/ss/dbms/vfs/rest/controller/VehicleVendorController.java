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
import com.bits.mtech.ss.dbms.vfs.entity.VehicleVendor;
import com.bits.mtech.ss.dbms.vfs.entity.repository.VehicleVendorRepository;

@RestController
public class VehicleVendorController {
	@Autowired
	private VehicleVendorRepository vehicleVendorRepository;
	
	@GetMapping("/vehicleVendors")
	public List<VehicleVendor> retrieveAllVehicleVendors() {
		return vehicleVendorRepository.findAll();
	}
	
	@GetMapping("/vehicleVendors/{id}")
	public VehicleVendor retrieveVehicleVendor(@PathVariable long id) {
		Optional<VehicleVendor> vehicleVendor = vehicleVendorRepository.findById(id);

		if (!vehicleVendor.isPresent())
			throw new VfsException(String.format("Not founnd id-%s" , id));

		return vehicleVendor.get();
	}
	
	@DeleteMapping("/vehicleVendors/{id}")
	public void deleteVehicleVendor(@PathVariable long id) {
		vehicleVendorRepository.deleteById(id);
	}
	
	
	@PostMapping("/vehicleVendors")
	public ResponseEntity<Object> createVehicleVendor(@RequestBody VehicleVendor vehicleVendor) {
		VehicleVendor savedVehicleVendor = vehicleVendorRepository.save(vehicleVendor);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedVehicleVendor.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/vehicleVendors/{id}")
	public ResponseEntity<Object> updateVehicleVendor(@RequestBody VehicleVendor vehicleVendor, @PathVariable long id) {

		Optional<VehicleVendor> vehicleVendorOptional = vehicleVendorRepository.findById(id);

		if (!vehicleVendorOptional.isPresent())
			return ResponseEntity.notFound().build();

		vehicleVendor.setId(id);
		
		vehicleVendorRepository.save(vehicleVendor);

		return ResponseEntity.noContent().build();
	}
	


}
