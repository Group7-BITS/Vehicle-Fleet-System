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
import com.bits.mtech.ss.dbms.vfs.entity.Driver;
import com.bits.mtech.ss.dbms.vfs.entity.repository.DriverRepository;

@RestController
public class DriverController {

	@Autowired
	private DriverRepository driverRepository;
	
	@GetMapping("/driver")
	public List<Driver> retrieveAllDriver() {
		return driverRepository.findAll();
	}
	
	@GetMapping("/driver/{id}")
	public Driver retrieveDriver(@PathVariable long id) {
		Optional<Driver> driver = driverRepository.findById(id);

		if (!driver.isPresent())
			throw new VfsException(String.format("Not founnd id-%s" , id));

		return driver.get();
	}
	
	@DeleteMapping("/driver/{id}")
	public void deleteDriver(@PathVariable long id) {
		driverRepository.deleteById(id);
	}
	
	
	@PostMapping("/driver")
	public ResponseEntity<Object> createDriver(@RequestBody Driver driver) {
		Driver savedDriver = driverRepository.save(driver);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedDriver.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/driver/{id}")
	public ResponseEntity<Object> updateDriver(@RequestBody Driver driver, @PathVariable long id) {

		Optional<Driver> driverOptional = driverRepository.findById(id);

		if (!driverOptional.isPresent())
			return ResponseEntity.notFound().build();

		driver.setId(id);
		
		driverRepository.save(driver);

		return ResponseEntity.noContent().build();
	}


}
