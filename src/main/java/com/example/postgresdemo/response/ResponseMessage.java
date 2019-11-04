package com.example.postgresdemo.response;

public class ResponseMessage {
	public String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseMessage [message=" + message + "]";
	}
}
