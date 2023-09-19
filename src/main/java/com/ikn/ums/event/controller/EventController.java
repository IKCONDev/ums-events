package com.ikn.ums.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikcon.ums.event.exception.BusinessException;
import com.ikcon.ums.event.exception.ControllerException;
import com.ikcon.ums.event.exception.ErrorCodeMessages;
import com.ikn.ums.event.service.EventService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/meetings")
@Slf4j
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("/save")
	public ResponseEntity<?> createEvent(){
		//TODO: create event
		return null;
	}
	
	/**
	 * delete the action items of an event by commnunicating with action items microservice
	 * @param actionItemIds
	 * @return
	 */
	@GetMapping("/delete/ac-items/{eventId}/{actionItemIds}")
	public ResponseEntity<?> deleteActionItemsOfEvent(@PathVariable Integer eventId, @PathVariable String actionItemIds){
		log.info("EventController.deleteActionItemsOfEvent() entered with args : eventId - "+eventId+" actionItemIds - "+actionItemIds);
		try {
			log.info("EventController.deleteActionItemsOfEvent() is under execution");
			//String[] idsFromUI = actionItemIds.split(",");
			//List<String> idsList =  Arrays.asList(idsFromUI);
			//convert string of ids to Integer ids
			// List<Integer> actualIds = idsList.stream()
              //       .map(s -> Integer.parseInt(s))
                //     .collect(Collectors.toList());
			boolean isAllDeleted = eventService.removeActionItemsOfEvent(actionItemIds, eventId);
			System.out.println(isAllDeleted);
			if(isAllDeleted) {
				log.info("EventController.deleteActionItemsOfEvent() exiting successfully by returning "+isAllDeleted);
				return new ResponseEntity<Boolean>(isAllDeleted,HttpStatus.OK);
			}else {
				log.info("EventController.deleteActionItemsOfEvent() exiting successfully by returning "+isAllDeleted);
				return new ResponseEntity<Boolean>(isAllDeleted,HttpStatus.OK);
			}
		}
		catch (Exception e) {
			log.info("EventController.deleteActionItemsOfEvent() exited with exception "+e.getMessage());
			ControllerException umsCE = new ControllerException( ErrorCodeMessages.ERR_EVENTS_CONTROLLER_EXCEPTION_CODE,
					ErrorCodeMessages.ERR_EVENTS_CONTROLLER_EXCEPTION_MSG+" "+e.fillInStackTrace());
			return new ResponseEntity<>(umsCE, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("")
	public ResponseEntity<?> editActionItemOfEvent(Integer id){
		return null;
		
	}
	
	public ResponseEntity<?> submitActionItems(){
		return null;
		
	}

}
