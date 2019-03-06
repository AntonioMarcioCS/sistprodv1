package com.antoniomarciocs.sistprodv1.resources.exceptions;

public class FieldMessage {

	private String fildName;
	private String message;
	
	public FieldMessage() {
		
	}

	public FieldMessage(String fildName, String message) {
		super();
		this.fildName = fildName;
		this.message = message;
	}

	public String getFildName() {
		return fildName;
	}

	public void setFildName(String fildName) {
		this.fildName = fildName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
