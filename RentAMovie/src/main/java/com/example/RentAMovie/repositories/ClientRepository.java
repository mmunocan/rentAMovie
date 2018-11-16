package com.example.RentAMovie.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.RentAMovie.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Integer>{
	
}
