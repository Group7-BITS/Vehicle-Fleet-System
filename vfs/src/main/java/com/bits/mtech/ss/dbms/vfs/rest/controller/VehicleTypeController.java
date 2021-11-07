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
import com.bits.mtech.ss.dbms.vfs.entity.VehicleType;
import com.bits.mtech.ss.dbms.vfs.entity.repository.VehicleTypeRepository;

@RestController
public class VehicleTypeController {
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	
	@GetMapping("/vehicleTypes")
	public List<VehicleType> retrieveAllVehicleTypes() {
		return vehicleTypeRepository.findAll();
	}
	
	@GetMapping("/vehicleTypes/{id}")
	public VehicleType retrieveVehicleType(@PathVariable long id) {
		Optional<VehicleType> vehicleType = vehicleTypeRepository.findById(id);

		if (!vehicleType.isPresent())
			throw new VfsException(String.format("Not founnd id-%s" , id));

		return vehicleType.get();
	}
	
	@DeleteMapping("/vehicleTypes/{id}")
	public void deleteVehicleType(@PathVariable long id) {
		vehicleTypeRepository.deleteById(id);
	}
	
	
	@PostMapping("/vehicleTypes")
	public ResponseEntity<Object> createVehicleType(@RequestBody VehicleType vehicleType) {
		VehicleType savedVehicleType = vehicleTypeRepository.save(vehicleType);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedVehicleType.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/vehicleTypes/{id}")
	public ResponseEntity<Object> updateVehicleType(@RequestBody VehicleType vehicleType, @PathVariable long id) {

		Optional<VehicleType> vehicleTypeOptional = vehicleTypeRepository.findById(id);

		if (!vehicleTypeOptional.isPresent())
			return ResponseEntity.notFound().build();

		vehicleType.setId(id);
		
		vehicleTypeRepository.save(vehicleType);

		return ResponseEntity.noContent().build();
	}
	


}
