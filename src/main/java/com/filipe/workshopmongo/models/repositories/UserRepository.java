package com.filipe.workshopmongo.models.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.filipe.workshopmongo.models.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
