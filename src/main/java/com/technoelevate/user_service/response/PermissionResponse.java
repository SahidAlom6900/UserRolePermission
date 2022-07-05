package com.technoelevate.user_service.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PermissionResponse implements Serializable{
	
	private boolean error;
	
	private String message;
	
	private Object data;

}
