package Controller;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import Model.Computador;

@WebService
@SOAPBinding(style = Style.RPC)
public interface IComputadorController {
	@WebMethod
	Computador getComputador(int id);
	@WebMethod
	void post();
	@WebMethod
	void put();
	@WebMethod
	void delete();
}
