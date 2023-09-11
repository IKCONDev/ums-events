package com.ikn.ums.event.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
			e.printStackTrace();
			
		}
		return isDeleted;
	}

}
