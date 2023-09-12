package com.ikn.ums.event.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ikcon.ums.event.exception.BusinessException;
import com.ikn.ums.event.service.EventService;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public boolean removeActionItemsOfEvent(String acitemIds, Integer eventId) {
		boolean isDeleted = false;
		try {
			restTemplate.delete("http://UMS-ACTIONITEMS-SERVICE/api/actions/ac-items/delete/"+acitemIds);
			System.out.println("delete");
			isDeleted = true;
		}catch (Exception e) {
			throw new BusinessException("1001", e.getStackTrace().toString());
		}
		return isDeleted;
	}

}
