package com.activos.activos_fijos.util.exceptions;

/**
 * @author dmo11
 *
 */
public class Message {
	private String message;
	private int httpStatus;
	private String url;

	public Message(String message, int httpStatus, String url) {
		this.message = message;
		this.httpStatus = httpStatus;
		this.url = url;
	}
	
	public Message(Exception message, int httpStatus, String url) {
		this.message = message.getMessage();
		this.httpStatus = httpStatus;
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
