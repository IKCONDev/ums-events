package com.ikn.ums.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ikn.ums.event.service.EventService;

@RestController
@RequestMapping("/meetings")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("/save")
	public ResponseEntity<?> createMeeting(){
		//TODO:
		return null;
	}
	
	/**
	 * delete the action items of an event by commnunicating with action items microservice
	 * @param actionItemIds
	 * @return
	 */
	@GetMapping("/delete/ac-items/{eventId}/{actionItemIds}")
	public ResponseEntity<?> deleteActionItemsOfEvent(@PathVariable Integer eventId, @PathVariable String actionItemIds){
		System.out.println(actionItemIds);
		try {
			//String[] idsFromUI = actionItemIds.split(",");
			//List<String> idsList =  Arrays.asList(idsFromUI);
			//convert string of ids to Integer ids
			// List<Integer> actualIds = idsList.stream()
              //       .map(s -> Integer.parseInt(s))
                //     .collect(Collectors.toList());
			boolean isAllDeleted = eventService.removeActionItemsOfEvent(actionItemIds, eventId);
			System.out.println(isAllDeleted);
			if(isAllDeleted) {
				return new ResponseEntity<Boolean>(isAllDeleted,HttpStatus.OK);
			}else {
				return new ResponseEntity<Boolean>(isAllDeleted,HttpStatus.OK);
			}
		}catch (Exception e) {
			return new ResponseEntity<>("Could not delete action items, please try again", HttpStatus.INTERNAL_SERVER_ERROR);
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
