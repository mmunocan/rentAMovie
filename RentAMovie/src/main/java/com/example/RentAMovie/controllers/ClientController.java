package com.example.RentAMovie.controllers;

import com.example.RentAMovie.entities.Client;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.RentAMovie.services.ClientService;


@RestController
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/client")
	public ResponseEntity<Object> getAll(){
		try {
			return new ResponseEntity<>(clientService.getAll(),HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/client/{id}")
	public ResponseEntity<Object> getClient(@PathVariable("id") Integer id) {
		try {
			Optional<Client> client = clientService.getClient(id);
			if(client.isPresent()) {
				return new ResponseEntity<>(client.get(),HttpStatus.OK);
			}
			return ResponseEntity.notFound().build();
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/client")
	public ResponseEntity<Object> createClient(@RequestBody Client client){
		try {
			clientService.saveClient(client);
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/client/{id}")
	public ResponseEntity<Object> updateClient(@PathVariable("id") Integer id, @RequestBody Client client){
		try {
			if(clientService.updateClient(id, client)) {
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.notFound().build();
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("/client/{id}")
	public ResponseEntity<Object> deleteClient(@PathVariable("id") Integer id) {
		try {
			if(clientService.deleteClient(id)) {
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.notFound().build();
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
