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
import com.bits.mtech.ss.dbms.vfs.entity.Booking;
import com.bits.mtech.ss.dbms.vfs.entity.repository.BookingRepository;

@RestController
public class BookingController {

	@Autowired
	private BookingRepository bookingRepository;
	
	@GetMapping("/booking")
	public List<Booking> retrieveAllBooking() {
		return bookingRepository.findAll();
	}
	
	@GetMapping("/booking/{id}")
	public Booking retrieveBooking(@PathVariable long id) {
		Optional<Booking> booking = bookingRepository.findById(id);

		if (!booking.isPresent())
			throw new VfsException(String.format("Not founnd id-%s" , id));

		return booking.get();
	}
	
	@DeleteMapping("/booking/{id}")
	public void deleteBooking(@PathVariable long id) {
		bookingRepository.deleteById(id);
	}
	
	
	@PostMapping("/booking")
	public ResponseEntity<Object> createBooking(@RequestBody Booking booking) {
		Booking savedBooking = bookingRepository.save(booking);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedBooking.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/booking/{id}")
	public ResponseEntity<Object> updateBooking(@RequestBody Booking booking, @PathVariable long id) {

		Optional<Booking> bookingOptional = bookingRepository.findById(id);

		if (!bookingOptional.isPresent())
			return ResponseEntity.notFound().build();

		booking.setId(id);
		
		bookingRepository.save(booking);

		return ResponseEntity.noContent().build();
	}


}
