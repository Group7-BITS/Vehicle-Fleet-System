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
import com.bits.mtech.ss.dbms.vfs.entity.VehicleProblemType;
import com.bits.mtech.ss.dbms.vfs.entity.repository.VehicleProblemTypeRepository;

@RestController
public class VehicleProblemTypeController {
	@Autowired
	private VehicleProblemTypeRepository vehicleProblemTypeRepository;
	
	@GetMapping("/vehicleProblemTypes")
	public List<VehicleProblemType> retrieveAllVehicleProblemTypes() {
		return vehicleProblemTypeRepository.findAll();
	}
	
	@GetMapping("/vehicleProblemTypes/{id}")
	public VehicleProblemType retrieveVehicleProblemType(@PathVariable long id) {
		Optional<VehicleProblemType> vehicleProblemType = vehicleProblemTypeRepository.findById(id);

		if (!vehicleProblemType.isPresent())
			throw new VfsException(String.format("Not founnd id-%s" , id));

		return vehicleProblemType.get();
	}
	
	@DeleteMapping("/vehicleProblemTypes/{id}")
	public void deleteVehicleProblemType(@PathVariable long id) {
		vehicleProblemTypeRepository.deleteById(id);
	}
	
	
	@PostMapping("/vehicleProblemTypes")
	public ResponseEntity<Object> createVehicleProblemType(@RequestBody VehicleProblemType vehicleProblemType) {
		VehicleProblemType savedVehicleProblemType = vehicleProblemTypeRepository.save(vehicleProblemType);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedVehicleProblemType.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/vehicleProblemTypes/{id}")
	public ResponseEntity<Object> updateVehicleProblemType(@RequestBody VehicleProblemType vehicleProblemType, @PathVariable long id) {

		Optional<VehicleProblemType> vehicleProblemTypeOptional = vehicleProblemTypeRepository.findById(id);

		if (!vehicleProblemTypeOptional.isPresent())
			return ResponseEntity.notFound().build();

		vehicleProblemType.setId(id);
		
		vehicleProblemTypeRepository.save(vehicleProblemType);

		return ResponseEntity.noContent().build();
	}
	


}
