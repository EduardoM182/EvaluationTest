package com.evaluation.truper.client.list.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.truper.client.list.dto.ShopList;
import com.evaluation.truper.client.list.repository.ShopListRepository;
import com.evaluation.truper.client.list.service.ShopListService;

@Service
public class ShopListServiceImplements implements ShopListService {

	@Autowired
	ShopListRepository shopListRepo; 
	
	@Override
	public void saveShopList(ShopList shopList) {
		// TODO Auto-generated method stub
		shopListRepo.save(shopList);
	}

	@Override
	public ShopList getShopListByClient(int idShopList) {
		return shopListRepo.getReferenceById(idShopList);
	}

	@Override
	public void updateShopList(ShopList shopList) {
		ShopList updateShopList = shopListRepo.getReferenceById(shopList.getIdShopList());
		updateShopList.setListName(shopList.getListName());
		updateShopList.setDetailList(shopList.getDetailList());
		shopListRepo.save(updateShopList);
	}

	@Override
	public void deleteShopList(int idShopList) {
		shopListRepo.deleteById(idShopList);
	}
	

}
