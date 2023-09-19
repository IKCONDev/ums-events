package com.ikn.ums.event.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ikcon.ums.event.exception.BusinessException;
import com.ikcon.ums.event.exception.ErrorCodeMessages;
import com.ikn.ums.event.service.EventService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EventServiceImpl implements EventService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public boolean removeActionItemsOfEvent(String acitemIds, Integer eventId) {
		System.out.println("EventServiceImpl.removeActionItemsOfEvent()");
		log.info("EventServiceImpl.removeActionItemsOfEvent() entered with args : actionItemIds - "+acitemIds+" evenId - "+eventId);
		boolean isDeleted = false;
		try {
			log.info("EventServiceImpl.removeActionItemsOfEvent() is under execution");
			restTemplate.delete("http://UMS-ACTIONITEMS-SERVICE/api/actions/ac-items/delete/"+acitemIds);
			isDeleted = true;
		}catch (RestClientException re) {
			log.info("EventServiceImpl.removeActionItemsOfEvent() exited with exeception "+re.getMessage());
			throw new BusinessException(ErrorCodeMessages.ERR_ACTIONS_WS_REST_CLIENT_EXCEPTION_CODE, 
					ErrorCodeMessages.ERR_ACTIONS_WS_REST_CLIENT_EXCEPTION_MSG);
		}
		log.info("EventServiceImpl.removeActionItemsOfEvent() exited sucessfully by returning "+isDeleted);
		return isDeleted;
	}

}
