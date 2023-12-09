package com.evaluation.truper.client.list.dto;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class ShopList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idShopList;
	
	private String listName;
	private Date registerDate;
	private Date lastDate;
	private boolean status;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_list", referencedColumnName = "idClient")
	private Client client;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<DetailList> detailList;
}
