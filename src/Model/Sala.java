package Model;

import java.util.LinkedList;

public class Sala {
	private int id;
	private LinkedList<Computador> computadores;

	public Sala(int id) {
		this.computadores = new LinkedList<Computador>();
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException();
		}
		this.id = id;
	}

	public String getComputadores() {
		String msg = "";
		for (int i = 0; i < computadores.size(); i++) {
			msg += computadores.get(i).toString() + "\n";
		}
		return msg;
	}

	public Computador getComputadorById(int id) {
		for (int i = 0; i < computadores.size(); i++) {
			if (computadores.get(i).getId() == id) {
				return computadores.get(i);
			}
		}
		return new Computador(null, null, 0);
	}

	public void updateComputador(Computador pc) {
		for (int i = 0; i < computadores.size(); i++) {
			if (computadores.get(i).getId() == pc.getId()) {
				computadores.remove(i);
				computadores.add(pc);
			}
		}
	}

	public LinkedList<Computador> getComputeresLista() {
		return computadores;
	}

	public void addComputador(Computador computador) {
		if (computador == null) {
			throw new IllegalArgumentException();
		}
		this.computadores.add(computador);
	}

	public void removeComputador(int id) {
		if (id >= 0) {
			this.computadores.remove(id);
		}
	}

}
