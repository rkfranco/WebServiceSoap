package Controller;

import javax.jws.WebMethod;

import Model.Sala;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ISalaController {
	@WebMethod
	Sala getSala(int id);

	@WebMethod
	void post();

	@WebMethod
	void put();

	@WebMethod
	void delete();
}
