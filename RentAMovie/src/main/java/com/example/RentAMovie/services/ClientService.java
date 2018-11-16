package com.example.RentAMovie.services;

import com.example.RentAMovie.entities.Client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RentAMovie.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getAll(){
		return (List<Client>)clientRepository.findAll();
	}
	
	public Optional<Client> getClient(Integer id) {
		return clientRepository.findById(id);
	}
	
	public void saveClient(Client client) {
		clientRepository.save(client);
	}
	
	public boolean updateClient(Integer id, Client client) {
		Optional<Client> found = clientRepository.findById(id);
		if(found.isPresent()) {
			found.get().setName(client.getName());
			found.get().setPhone(client.getPhone());
			found.get().setEmail(client.getEmail());
			found.get().setId(id);
			clientRepository.save(found.get());
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean deleteClient(Integer id) {
		Optional<Client> client = clientRepository.findById(id);
		if(client.isPresent()) {
			clientRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
}
