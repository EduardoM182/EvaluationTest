package com.evaluation.truper.client.list.service.implement;

import org.springframework.beans.factory.annotation.Autowired;

import com.evaluation.truper.client.list.dto.DetailList;
import com.evaluation.truper.client.list.repository.DetailListRepository;
import com.evaluation.truper.client.list.service.DetailListService;

public class DetailListServiceImplements implements DetailListService{

	@Autowired
	DetailListRepository detailListRepo;
	
	@Override
	public void updateDetailList(DetailList detailList) {
		detailListRepo.save(detailList);
	}

}
