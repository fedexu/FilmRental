package com.filmrental.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.filmrental.model.FilmRequest;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
public interface WSRequest {
	
	@WebMethod
	String getOtherRequest(FilmRequest filmreq);

	@WebMethod
	List<FilmRequest> getListRequest();
}
