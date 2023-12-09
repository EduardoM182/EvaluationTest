package com.evaluation.truper.client.list.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClient;
	
	private String clientName;

	private boolean status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ShopList")
	private List<ShopList> shopList;
}
