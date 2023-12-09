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
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduct;
	
	//Clave
	private String productCode;
	private String description;
	
	//is a Bit it represents if is active
	private boolean status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "DetailList")
	private List<DetailList> detailList;
}
