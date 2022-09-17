package Controller;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface IBaseController {

	@WebMethod
	String getComputadoresSala(int id);

	@WebMethod
	void postSala(int id);

	@WebMethod
	void putSala(int id);

	@WebMethod
	void deleteSala(int id);

	@WebMethod
	String getComputador(int id);

	@WebMethod
	void postComputador(String modelo, String marca, int id, int idSala);

	@WebMethod
	void putComputador(String modelo, String marca, int id);

	@WebMethod
	void deleteComputador(int id);
}
