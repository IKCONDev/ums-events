package com.ikn.ums.event.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteActionItemRequestModel {
	
	private Integer eventId;
	private List<Integer> actionItemids;

}
