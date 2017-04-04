package com.filmrental.ws;

import java.util.List;
import javax.jws.WebService;
import com.filmrental.businesslogic.Store;
import com.filmrental.model.FilmRequest;

@WebService(endpointInterface = "com.filmrental.ws.WSRequest")
public class WSRequestImpl implements WSRequest {

	@Override
	public String getOtherRequest(FilmRequest f) {
		Store s = new Store();
		String message;
		try {
			s.addRequestByUser(f.getUserId(), f.getTitle(), f.getRegist(), f.getExitYear());
			message = "Your Request has been submitted, thanks.";
		} catch (Exception e) {
			e.printStackTrace();
			message = "Your Request isn't correct. Please repeat.";
		}
		return message;
	}

	@Override
	public List<FilmRequest> getListRequest() {
		Store s = new Store();
		List<FilmRequest> list = s.selectAllRequest();
		return list;
	}
}
