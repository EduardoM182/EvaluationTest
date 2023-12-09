package com.evaluation.truper.client.list.dto;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class DetailList {

	@EmbeddedId
	private DetailListId detailListId;
	
	
	private int cantidad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_detail_list", referencedColumnName = "idProduct")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "detail_shop_list", referencedColumnName = "idShopList")
	private ShopList shopList;
}
