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
import com.bits.mtech.ss.dbms.vfs.entity.VehicleInsurance;
import com.bits.mtech.ss.dbms.vfs.entity.repository.VehicleInsuranceRepository;

@RestController
public class VehicleInsuranceController {

	@Autowired
	private VehicleInsuranceRepository vehicleInsuranceRepository;
	
	@GetMapping("/vehicleInsurance")
	public List<VehicleInsurance> retrieveAllVehicleInsurance() {
		return vehicleInsuranceRepository.findAll();
	}
	
	@GetMapping("/vehicleInsurance/{id}")
	public VehicleInsurance retrieveVehicleInsurance(@PathVariable long id) {
		Optional<VehicleInsurance> vehicleInsurance = vehicleInsuranceRepository.findById(id);

		if (!vehicleInsurance.isPresent())
			throw new VfsException(String.format("Not founnd id-%s" , id));

		return vehicleInsurance.get();
	}
	
	@DeleteMapping("/vehicleInsurance/{id}")
	public void deleteVehicleInsurance(@PathVariable long id) {
		vehicleInsuranceRepository.deleteById(id);
	}
	
	
	@PostMapping("/vehicleInsurance")
	public ResponseEntity<Object> createVehicleInsurance(@RequestBody VehicleInsurance vehicleInsurance) {
		VehicleInsurance savedVehicleInsurance = vehicleInsuranceRepository.save(vehicleInsurance);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedVehicleInsurance.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/vehicleInsurance/{id}")
	public ResponseEntity<Object> updateVehicleInsurance(@RequestBody VehicleInsurance vehicleInsurance, @PathVariable long id) {

		Optional<VehicleInsurance> vehicleInsuranceOptional = vehicleInsuranceRepository.findById(id);

		if (!vehicleInsuranceOptional.isPresent())
			return ResponseEntity.notFound().build();

		vehicleInsurance.setId(id);
		
		vehicleInsuranceRepository.save(vehicleInsurance);

		return ResponseEntity.noContent().build();
	}


}
