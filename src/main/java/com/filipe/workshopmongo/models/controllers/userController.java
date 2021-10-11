package com.filipe.workshopmongo.models.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.filipe.workshopmongo.models.dto.UserDTO;
import com.filipe.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class userController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		UserDTO user = service.findById(id);		
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> findById(@RequestBody UserDTO obj) {
		obj = service.insert(obj);		
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(obj.getId())
					.toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDTO> putById(@RequestBody UserDTO obj, @PathVariable String id) {
		obj = service.update(id, obj);			
		return ResponseEntity.ok().body(obj);
	}
}
