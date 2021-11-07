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
import com.bits.mtech.ss.dbms.vfs.entity.UserRole;
import com.bits.mtech.ss.dbms.vfs.entity.repository.UserRoleRepository;

@RestController
public class UserRoleController {
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@GetMapping("/userRoles")
	public List<UserRole> retrieveAllUserRoles() {
		return userRoleRepository.findAll();
	}
	
	@GetMapping("/userRoles/{id}")
	public UserRole retrieveUserRole(@PathVariable long id) {
		Optional<UserRole> userRole = userRoleRepository.findById(id);

		if (!userRole.isPresent())
			throw new VfsException(String.format("Not founnd id-%s" , id));

		return userRole.get();
	}
	
	@DeleteMapping("/userRoles/{id}")
	public void deleteUserRole(@PathVariable long id) {
		userRoleRepository.deleteById(id);
	}
	
	
	@PostMapping("/userRoles")
	public ResponseEntity<Object> createUserRole(@RequestBody UserRole userRole) {
		UserRole savedUserRole = userRoleRepository.save(userRole);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUserRole.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/userRoles/{id}")
	public ResponseEntity<Object> updateUserRole(@RequestBody UserRole userRole, @PathVariable long id) {

		Optional<UserRole> userRoleOptional = userRoleRepository.findById(id);

		if (!userRoleOptional.isPresent())
			return ResponseEntity.notFound().build();

		userRole.setId(id);
		
		userRoleRepository.save(userRole);

		return ResponseEntity.noContent().build();
	}
	


}
