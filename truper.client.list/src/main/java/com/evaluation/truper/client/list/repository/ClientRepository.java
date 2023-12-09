package com.evaluation.truper.client.list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluation.truper.client.list.dto.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
