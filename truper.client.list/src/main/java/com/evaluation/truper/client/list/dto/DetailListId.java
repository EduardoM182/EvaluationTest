package com.evaluation.truper.client.list.dto;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class DetailListId{

	private int idDetailList;
	private int productCode;
	
}
