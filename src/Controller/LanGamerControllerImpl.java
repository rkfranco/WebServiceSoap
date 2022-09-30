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
		String msg = "Sala nao encontrada";
		for (int i = 0; i < salas.size(); i++) {
			if (salas.get(i).getId() == id) {
				msg = salas.get(i).getComputadores();
			}
		}
		return msg;
	}

	@Override
	public String postSala(int id, String responsavelSala, int numMaxComputadores) {
		boolean repetido = false;
		for (int i = 0; i < salas.size(); i++) {
			if (salas.get(i).getId() == id) {
				repetido = true;
				return "Sala ja cadastrada";
			}
		}
		if (!repetido) {
			salas.add(new Sala(id, responsavelSala, numMaxComputadores));
		}
		return "Sala inserida com sucesso";
	}

	@Override
	public String putSala(int id, String responsavelSala, int numMaxComputadores) {
		for (int i = 0; i < salas.size(); i++) {
			if (salas.get(i).getId() == id) {
				salas.remove(i);
				salas.add(new Sala(id, responsavelSala, numMaxComputadores));
				return "Sala atualizada com sucesso";
			}
		}
		return "Sala nao encontrada";
	}

	@Override
	public String deleteSala(int id) {
		for (int i = 0; i < salas.size(); i++) {
			if (salas.get(i).getId() == id) {
				if (salas.get(i).getComputeresLista().size() != 0) {
					return "Sala nao removida, ainda ha computadores dentro";
				} else {
					salas.remove(i);
					return "Sala removida com sucesso";
				}
			}
		}
		return "Sala nao encontrada";
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
		return "Computador nao encontrado";
	}

	@Override
	public String postComputador(String modelo, String marca, int id, int idSala) {
		Computador pc;
		LinkedList<Computador> listaPc;
		for (int i = 0; i < salas.size(); i++) {
			listaPc = salas.get(i).getComputeresLista();
			for (int j = 0; j < listaPc.size(); j++) {
				pc = listaPc.get(j);
				if (pc != null && pc.getId() == id) {
					return "ID ja cadastrado";
				}
			}
		}
		for (int i = 0; i < salas.size(); i++) {
			if (salas.get(i).getId() == idSala
					&& !(salas.get(i).getComputeresLista().size() >= salas.get(i).getNumMaxComputadores())) {
				salas.get(i).addComputador(new Computador(modelo, marca, id));
				return "Cadastro realizado com sucesso";
			}
		}
		return "Ocorreu um erro ao cadastrar o computador, verificar existencia da sala, ou seu numero maximo de computadores permitidos";
	}

	@Override
	public String putComputador(String modelo, String marca, int id) {
		for (int i = 0; i < salas.size(); i++) {
			for (int j = 0; j < salas.get(i).getComputeresLista().size(); j++) {
				if (salas.get(i).getComputadorById(j).getId() == id) {
					salas.get(i).updateComputador(new Computador(modelo, marca, id));
					return "Computador atualizado com sucesso";
				}
			}
		}
		return "Computador nao encontrado";
	}

	@Override
	public String deleteComputador(int id) {
		Sala sala;
		LinkedList<Computador> listaPc;
		for (int i = 0; i < salas.size(); i++) {
			sala = salas.get(i);
			listaPc = sala.getComputeresLista();
			for (int j = 0; j < listaPc.size(); j++) {
				if (listaPc.get(j).getId() == id) {
					sala.getComputeresLista().remove(j);
					return "Computador removido com sucesso";
				}
			}
		}
		return "Computador nao encontrado";
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
	public boolean addDefeito(String defeito, int id) {
		Computador pc;
		for (int i = 0; i < salas.size(); i++) {
			Sala s = salas.get(i);
			for (int j = 0; j < s.getComputeresLista().size(); j++) {
				pc = s.getComputeresLista().get(j);
				if (pc.getId() == id) {
					pc.addDefeitos(defeito);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean limpaDefeitos(int id) {
		Computador pc;
		for (int i = 0; i < salas.size(); i++) {
			Sala s = salas.get(i);
			for (int j = 0; j < s.getComputeresLista().size(); j++) {
				pc = s.getComputeresLista().get(j);
				if (pc.getId() == id) {
					pc.removeDefeitos();
					return true;
				}
			}
		}
		return false;
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
