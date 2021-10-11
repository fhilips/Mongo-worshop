package com.filipe.workshopmongo.config;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.filipe.workshopmongo.models.entities.User;
import com.filipe.workshopmongo.models.repositories.PostRepository;
import com.filipe.workshopmongo.models.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@PostConstruct
	public void init() {
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User filipe = new User(null, "Filipe", "filipe@gmail.com");
		User mara = new User(null, "Mara", "mara@gmail.com");
		User charles = new User(null, "Charles", "charles@gmail.com");		
		
		userRepository.saveAll(Arrays.asList(filipe, mara, charles));
	}
}
