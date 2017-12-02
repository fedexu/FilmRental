package com.filmrental;

/**
 * Wrapper generico di risposta per una chiamata REST
 * 
 * @author Federico Peruzzi
 * @version 1.0
 *
 */
public class RestResponseEntity<T> {

	/**
	 * Costruttore generico con l'oggetto payload
	 * 
	 * @param payload
	 */
	public RestResponseEntity(T payload) {
		super();
		this.payload = payload;
	}

	/**
	 * La proprieta payload deve contenere l'oggetto di risposta utile della logica di business
	 */
	private T payload;

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}
	
}
