package com.evaluation.truper.client.list.service;

import com.evaluation.truper.client.list.dto.ShopList;

public interface ShopListService {

	public void saveShopList(ShopList shopList);
	
	public ShopList getShopListByClient(int idShopList);
	
	public void updateShopList(ShopList shopList);
	
	public void deleteShopList(int idShopList);
}
