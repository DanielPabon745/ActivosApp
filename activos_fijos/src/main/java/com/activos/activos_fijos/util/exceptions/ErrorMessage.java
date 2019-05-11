package com.activos.activos_fijos.util.exceptions;

/**
 * @author dmo11
 *
 */
public class ErrorMessage {
	private String message;
	private int httpStatus;
	private String url;

	public ErrorMessage(String message, int httpStatus, String url) {
		this.message = message;
		this.httpStatus = httpStatus;
		this.url = url;
	}
	
	public ErrorMessage(Exception message, int httpStatus, String url) {
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
