package com.evaluation.truper.client.list.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.truper.client.list.dto.Client;
import com.evaluation.truper.client.list.repository.ClientRepository;
import com.evaluation.truper.client.list.service.ClientService;

@Service
public class ClientServiceImplements implements ClientService{

	@Autowired
	ClientRepository clientRepository;

	@Override
	public void save(Client client) {
		// TODO Auto-generated method stub
		clientRepository.save(client);
	}

	@Override
	public Client getClientById(int idClient) {
		return clientRepository.getReferenceById(idClient);
	}
	
}
