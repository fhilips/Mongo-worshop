package com.filipe.workshopmongo.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filipe.workshopmongo.models.dto.PostDTO;
import com.filipe.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
	
	@Autowired
	private PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable String id) {
		PostDTO user = service.findById(id);		
		return ResponseEntity.ok().body(user);
	}	
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<PostDTO>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		List<PostDTO> user = service.findByTitle(text);		
		return ResponseEntity.ok().body(user);
	}
}
