package com.evaluation.truper.client.list.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.evaluation.truper.client.list.dto.Client;
import com.evaluation.truper.client.list.dto.ShopList;
import com.evaluation.truper.client.list.service.ClientService;
import com.evaluation.truper.client.list.service.ShopListService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = "/truper/v1")
@RequiredArgsConstructor
public class TruperServiceController {

	@Autowired
	ShopListService shopService ;
	
	@Autowired
	ClientService clientService;
	
	@GetMapping(value = "/getClientShopList/{idClient}")
	public ArrayList<ShopList> getAllShopListByClient(@PathVariable int idClient){
		
		System.out.printf("::::: {} ::::", "On getAllShopListByClient");
		
		Client client = clientService.getClientById(idClient);
		ArrayList<ShopList> allShop = new ArrayList<>();
		
		client.getShopList().forEach( sl -> {
			allShop.add(shopService.getShopListByClient(sl.getIdShopList()));
		});
		
		return allShop;
		
	}
	
	@DeleteMapping(value = "/deleteShopList/{idShopList}")
	public void deleteShopListById(@PathVariable int idShopList) {
		System.out.printf("::::: {} ::::", "On deleteShopListById");
		shopService.deleteShopList(idShopList);
	}
	
	@PostMapping(value = "/addingShopList/clients")
	public void addingShopListByClients(@RequestBody ArrayList<Client> clients) {
		System.out.printf("::::: {} ::::", "On addingShopListByClients");
		clients.forEach(client -> {
			clientService.save(client);
		});
	}
	
	@PutMapping(value = "/updateShopList/client")
	public void updateShopListByClient(@RequestBody Client requestClient) {
		System.out.printf("::::: {} ::::", "On updateShopListByClient");
		Client client = clientService.getClientById(requestClient.getIdClient());
		
		client.getShopList().forEach(shoplist -> {
			shopService.updateShopList(shoplist);
		});
	}
}
