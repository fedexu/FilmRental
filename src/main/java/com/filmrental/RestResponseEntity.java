package com.filmrental;

/**
 * Generic output wrapper for a REST call
 * 
 * @author Federico Peruzzi
 * @version 1.0
 *
 */
public class RestResponseEntity<T> {

	/**
	 * Generic constructor with the payload object
	 * 
	 * @param payload
	 */
	public RestResponseEntity(T payload) {
		super();
		this.payload = payload;
	}

	/**
	 * The payload field needs to hold the output object of the business logic 
	 */
	private T payload;

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}
	
}
