package com.evaluation.truper.client.list.service;

import com.evaluation.truper.client.list.dto.Client;

public interface ClientService {
	
	void save(Client client);
	
	public Client getClientById(int idClient);
	
}
