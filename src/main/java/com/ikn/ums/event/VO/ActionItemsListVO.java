package com.ikn.ums.event.VO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionItemsListVO {
	
	private List<ActionsItemsVO> actionItems;

}
