package Controller;

import java.util.LinkedList;
import java.util.Random;

import javax.jws.WebService;

import Model.Computador;
import Model.Sala;

@WebService(endpointInterface = "Controller.IBaseController")
public class LanGamerControllerImpl implements IBaseController {

	public static LinkedList<Sala> salas = new LinkedList<>();

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

	// add número maximo de pcs
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
		Computador pc;
		LinkedList<Computador> listaPc;
		for (int i = 0; i < salas.size(); i++) {
			listaPc = salas.get(i).getComputeresLista();
			for (int j = 0; j < listaPc.size(); j++) {
				pc = listaPc.get(j);
				if (pc != null && pc.getId() == id) {
					return pc.toString();
				}
			}
		}
		return "Computador não encontrado";
	}

	@Override
	public String postComputador(String modelo, String marca, int id, int idSala) {
		Computador pc;
		// Pela lista se privada o cliente não consegue ter acesso as informações, e por
		// isso dá erro de null exception.
		LinkedList<Computador> listaPc;
		for (int i = 0; i < salas.size(); i++) {
			listaPc = salas.get(i).getComputeresLista();
			for (int j = 0; j < listaPc.size(); j++) {
				pc = listaPc.get(j);
				if (pc != null && pc.getId() == id) {
					return "ID já cadastrado";
				}
			}
		}
		for (int i = 0; i < salas.size(); i++) {
			if (salas.get(i).getId() == idSala) {
				salas.get(i).addComputador(new Computador(modelo, marca, id));
				return "Cadastro realizado com sucesso";
			}
		}
		return "Ocorreu um erro ao cadastrar o computador";
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

	private boolean checkSession(int session) {
		Computador pc;
		LinkedList<Computador> listaPc;
		for (int i = 0; i < salas.size(); i++) {
			listaPc = salas.get(i).getComputeresLista();
			for (int j = 0; j < listaPc.size(); j++) {
				pc = listaPc.get(j);
				if (pc != null && pc.getSession() == session) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public int startSession(int id) {
		Random random = new Random();
		boolean repetido = false;
		int session = 0;
		while (!repetido) {
			session = random.nextInt(99);
			repetido = checkSession(session);
		}
		Computador pc;
		for (int i = 0; i < salas.size(); i++) {
			Sala s = salas.get(i);
			for (int j = 0; j < s.getComputeresLista().size(); j++) {
				pc = s.getComputeresLista().get(j);
				if (pc.getId() == id) {
					pc.setSession(session);
					return session;
				}
			}
		}
		return 0;
	}

	@Override
	public int endSession(int id) {
		Computador pc;
		for (int i = 0; i < salas.size(); i++) {
			Sala s = salas.get(i);
			for (int j = 0; j < s.getComputeresLista().size(); j++) {
				pc = s.getComputeresLista().get(j);
				if (pc.getId() == id) {
					int session = pc.getSession();
					pc.removeDefeitos();
					return session;
				}
			}
		}
		return 0;
	}

	@Override
	public void addDefeito(String defeito, int id) {
		Computador pc;
		for (int i = 0; i < salas.size(); i++) {
			Sala s = salas.get(i);
			for (int j = 0; j < s.getComputeresLista().size(); j++) {
				pc = s.getComputeresLista().get(j);
				if (pc.getId() == id) {
					pc.addDefeitos(defeito);
				}
			}
		}
	}

	@Override
	public void limpaDefeitos(int id) {
		Computador pc;
		for (int i = 0; i < salas.size(); i++) {
			Sala s = salas.get(i);
			for (int j = 0; j < s.getComputeresLista().size(); j++) {
				pc = s.getComputeresLista().get(j);
				if (pc.getId() == id) {
					pc.removeDefeitos();
				}
			}
		}
	}

	@Override
	public String getSala() {
		String s = "";
		for (Sala ss : salas) {
			for (int i = 0; i < ss.getComputeresLista().size(); i++) {
				s += ss.getId() + "\n" + ss.getComputadorById(i);
			}
		}
		return s;
	}

}
