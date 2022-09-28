package Controller;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import Model.Computador;

@WebService
@SOAPBinding(style = Style.RPC)
public interface IBaseController {
	
	@WebMethod
	String getComputadoresSala(int id);

	@WebMethod
	String getSala();
	
	@WebMethod
	String postSala(int id, String responsavelSala, int numMaxComputadores);

	@WebMethod
	String putSala(int id, String responsavelSala, int numMaxComputadores);

	@WebMethod
	String deleteSala(int id);
	
	@WebMethod
	String getComputador(int id);

	@WebMethod
	String postComputador(String modelo, String marca, int id, int idSala);

	@WebMethod
	String putComputador(String modelo, String marca, int id);

	@WebMethod
	String deleteComputador(int id);

	@WebMethod
	int startSession(int id);

	@WebMethod
	int endSession(int id);

	@WebMethod
	void addDefeito(String defeito, int id);

	@WebMethod
	void limpaDefeitos(int id);
}
