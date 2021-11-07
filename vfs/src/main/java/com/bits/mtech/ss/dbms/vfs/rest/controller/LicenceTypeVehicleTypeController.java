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
import com.bits.mtech.ss.dbms.vfs.entity.LicenseTypeVehicleType;
import com.bits.mtech.ss.dbms.vfs.entity.repository.LicenseTypeVehicleTypeRepository;

@RestController
public class LicenceTypeVehicleTypeController {

	@Autowired
	private LicenseTypeVehicleTypeRepository licenseTypeVehicleTypeRepository;
	
	@GetMapping("/licenseTypeVehicleType")
	public List<LicenseTypeVehicleType> retrieveAllLicenseTypeVehicleType() {
		return licenseTypeVehicleTypeRepository.findAll();
	}
	
	@GetMapping("/licenseTypeVehicleType/{id}")
	public LicenseTypeVehicleType retrieveLicenseTypeVehicleType(@PathVariable long id) {
		Optional<LicenseTypeVehicleType> licenseTypeVehicleType = licenseTypeVehicleTypeRepository.findById(id);

		if (!licenseTypeVehicleType.isPresent())
			throw new VfsException(String.format("Not founnd id-%s" , id));

		return licenseTypeVehicleType.get();
	}
	
	@DeleteMapping("/licenseTypeVehicleType/{id}")
	public void deleteLicenseTypeVehicleType(@PathVariable long id) {
		licenseTypeVehicleTypeRepository.deleteById(id);
	}
	
	
	@PostMapping("/licenseTypeVehicleType")
	public ResponseEntity<Object> createLicenseTypeVehicleType(@RequestBody LicenseTypeVehicleType licenseTypeVehicleType) {
		LicenseTypeVehicleType savedLicenseTypeVehicleType = licenseTypeVehicleTypeRepository.save(licenseTypeVehicleType);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedLicenseTypeVehicleType.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/licenseTypeVehicleType/{id}")
	public ResponseEntity<Object> updateLicenseTypeVehicleType(@RequestBody LicenseTypeVehicleType licenseTypeVehicleType, @PathVariable long id) {

		Optional<LicenseTypeVehicleType> licenseTypeVehicleTypeOptional = licenseTypeVehicleTypeRepository.findById(id);

		if (!licenseTypeVehicleTypeOptional.isPresent())
			return ResponseEntity.notFound().build();

		licenseTypeVehicleType.setId(id);
		
		licenseTypeVehicleTypeRepository.save(licenseTypeVehicleType);

		return ResponseEntity.noContent().build();
	}


}
