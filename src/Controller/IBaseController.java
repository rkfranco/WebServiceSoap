package Controller;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import Model.Computador;

@WebService
@SOAPBinding(style = Style.RPC)
public interface IBaseController {

	// Add String ou boolean de retorno para todos os métodos put, post e delete;
	// Add mais coisas a classe sala (está muito simples) Ex: número max de pcs, responsável pela sala;
	
	@WebMethod
	String getComputadoresSala(int id);

	@WebMethod
	String getSala();
	
	@WebMethod
	void postSala(int id);

	@WebMethod
	void putSala(int id);

	@WebMethod
	void deleteSala(int id);

	
	@WebMethod
	String getComputador(int id);

	@WebMethod
	String postComputador(String modelo, String marca, int id, int idSala);

	@WebMethod
	void putComputador(String modelo, String marca, int id);

	@WebMethod
	void deleteComputador(int id);

	@WebMethod
	int startSession(int id);

	@WebMethod
	int endSession(int id);

	@WebMethod
	void addDefeito(String defeito, int id);

	@WebMethod
	void limpaDefeitos(int id);

}
