package com.nuxeo.tracking.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionMessageDto {
	
	public Integer status;
	public String message;
    public String error;
    public String path;
    
}