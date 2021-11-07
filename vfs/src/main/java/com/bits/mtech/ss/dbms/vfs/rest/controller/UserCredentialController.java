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
import com.bits.mtech.ss.dbms.vfs.entity.UserCredential;
import com.bits.mtech.ss.dbms.vfs.entity.repository.UserCredentialRepository;

@RestController
public class UserCredentialController {

	@Autowired
	private UserCredentialRepository userCredentialRepository;
	
	@GetMapping("/userCredential")
	public List<UserCredential> retrieveAllUserCredential() {
		return userCredentialRepository.findAll();
	}
	
	@GetMapping("/userCredential/{id}")
	public UserCredential retrieveUserCredential(@PathVariable long id) {
		Optional<UserCredential> userCredential = userCredentialRepository.findById(id);

		if (!userCredential.isPresent())
			throw new VfsException(String.format("Not founnd id-%s" , id));

		return userCredential.get();
	}
	
	@DeleteMapping("/userCredential/{id}")
	public void deleteUserCredential(@PathVariable long id) {
		userCredentialRepository.deleteById(id);
	}
	
	
	@PostMapping("/userCredential")
	public ResponseEntity<Object> createUserCredential(@RequestBody UserCredential userCredential) {
		UserCredential savedUserCredential = userCredentialRepository.save(userCredential);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUserCredential.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/userCredential/{id}")
	public ResponseEntity<Object> updateUserCredential(@RequestBody UserCredential userCredential, @PathVariable long id) {

		Optional<UserCredential> userCredentialOptional = userCredentialRepository.findById(id);

		if (!userCredentialOptional.isPresent())
			return ResponseEntity.notFound().build();

		userCredential.setId(id);
		
		userCredentialRepository.save(userCredential);

		return ResponseEntity.noContent().build();
	}


}
