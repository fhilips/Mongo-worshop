package com.filipe.workshopmongo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.workshopmongo.models.dto.UserDTO;
import com.filipe.workshopmongo.models.entities.User;
import com.filipe.workshopmongo.models.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<UserDTO> findAll() {
		List<User> list = repository.findAll();
		
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
}
