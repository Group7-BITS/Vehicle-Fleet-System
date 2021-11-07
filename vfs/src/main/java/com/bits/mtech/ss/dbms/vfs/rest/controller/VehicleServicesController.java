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
import com.bits.mtech.ss.dbms.vfs.entity.VehicleServices;
import com.bits.mtech.ss.dbms.vfs.entity.repository.VehicleServicesRepository;

@RestController
public class VehicleServicesController {
	@Autowired
	private VehicleServicesRepository vehicleServicesRepository;
	
	@GetMapping("/vehicleServices")
	public List<VehicleServices> retrieveAllVehicleServicess() {
		return vehicleServicesRepository.findAll();
	}
	
	@GetMapping("/vehicleServices/{id}")
	public VehicleServices retrieveVehicleServices(@PathVariable long id) {
		Optional<VehicleServices> vehicleServices = vehicleServicesRepository.findById(id);

		if (!vehicleServices.isPresent())
			throw new VfsException(String.format("Not founnd id-%s" , id));

		return vehicleServices.get();
	}
	
	@DeleteMapping("/vehicleServices/{id}")
	public void deleteVehicleServices(@PathVariable long id) {
		vehicleServicesRepository.deleteById(id);
	}
	
	
	@PostMapping("/vehicleServices")
	public ResponseEntity<Object> createVehicleServices(@RequestBody VehicleServices vehicleServices) {
		VehicleServices savedVehicleServices = vehicleServicesRepository.save(vehicleServices);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedVehicleServices.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/vehicleServices/{id}")
	public ResponseEntity<Object> updateVehicleServices(@RequestBody VehicleServices vehicleServices, @PathVariable long id) {

		Optional<VehicleServices> vehicleServicesOptional = vehicleServicesRepository.findById(id);

		if (!vehicleServicesOptional.isPresent())
			return ResponseEntity.notFound().build();

		vehicleServices.setId(id);
		
		vehicleServicesRepository.save(vehicleServices);

		return ResponseEntity.noContent().build();
	}
	


}
