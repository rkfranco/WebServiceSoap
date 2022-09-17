package Controller;

import java.util.LinkedList;

import javax.jws.WebService;

import Model.Computador;
import Model.Sala;

@WebService(endpointInterface = "Controller.IBaseController")
public class LanGamerControllerImpl implements IBaseController {

	private LinkedList<Sala> salas = new LinkedList<>();
//	private LinkedList<Computador> computadores = new LinkedList<>();

	@Override
	public String getComputadoresSala(int id) {
		String msg = "Sala não encontrada";
		for (int i = 0; i < salas.size(); i++) {
			if (salas.get(i).getId() == id) {
				msg = salas.get(i).getComputadores();
			}
		}
		return msg;
	}

	@Override
	public void postSala(int id) {
		boolean repetido = false;
		for (int i = 0; i < salas.size(); i++) {
			if (salas.get(i).getId() == id) {
				repetido = true;
			}
		}
		if (!repetido) {
			salas.add(new Sala(id));
		}
	}

	@Override
	public void putSala(int id) {
		for (int i = 0; i < salas.size(); i++) {
			if (salas.get(i).getId() == id) {
				salas.remove(i);
				salas.add(new Sala(id));

			}
		}
	}

	@Override
	public void deleteSala(int id) {
		for (int i = 0; i < salas.size(); i++) {
			if (salas.get(i).getId() == id) {
				salas.remove(i);
			}
		}
	}

	@Override
	public String getComputador(int id) {
		for (int i = 0; i < salas.size(); i++) {
			for (int j = 0; j < salas.get(i).getComputeresLista().size(); j++) {
				if (salas.get(i).getComputadorById(j).getId() == id) {
					return salas.get(i).getComputadorById(j).toString();
				}
			}
		}
		return "Computador inexistente";
	}

	@Override
	public void postComputador(String modelo, String marca, int id, int idSala) {
		boolean repetido = false;
		for (int i = 0; i < salas.size(); i++) {
			for (int j = 0; j < salas.get(i).getComputeresLista().size(); j++) {
				if (salas.get(i).getComputadorById(j).getId() == id) {
					repetido = true;
				}
			}
		}
		if (!repetido) {
			for (int i = 0; i < salas.size(); i++) {
				if (salas.get(i).getId() == idSala) {
					salas.get(i).addComputador(new Computador(modelo, marca, id));
				}
			}
		}

	}

	@Override
	public void putComputador(String modelo, String marca, int id) {
		for (int i = 0; i < salas.size(); i++) {
			for (int j = 0; j < salas.get(i).getComputeresLista().size(); j++) {
				if (salas.get(i).getComputadorById(j).getId() == id) {
					salas.get(i).updateComputador(new Computador(modelo, marca, id));
				}
			}
		}
	}

	@Override
	public void deleteComputador(int id) {
		for (int i = 0; i < salas.size(); i++) {
			for (int j = 0; j < salas.get(i).getComputeresLista().size(); j++) {
				if (salas.get(i).getComputadorById(j).getId() == id) {
					salas.get(i).getComputeresLista().remove(j);
				}
			}
		}

	}

}
