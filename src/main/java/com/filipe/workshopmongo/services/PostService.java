package com.filipe.workshopmongo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.workshopmongo.models.dto.PostDTO;
import com.filipe.workshopmongo.models.entities.Post;
import com.filipe.workshopmongo.models.repositories.PostRepository;
import com.filipe.workshopmongo.services.exceptions.ResourceNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public PostDTO findById(String id) {
		Post entity = getEntityById(id);
		return new PostDTO(entity);
	}
		
	private Post getEntityById(String id) {
		Optional<Post> result = repository.findById(id);
		return result.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado!"));
	}
	
	public List<PostDTO> findByTitle(String text) {
		List<Post> list = repository.findByTitleContainingIgnoreCase(text);
		return list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
	}
	
}
