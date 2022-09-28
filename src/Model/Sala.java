package Model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Sala {
	private int id;
	private String responsavelSala;
	private int numMaxComputadores;
	private LinkedList<Computador> computadores;

	public Sala(int id, String responsavelSala, int numMaxComputadores) {
		this.computadores = new LinkedList<Computador>();
		this.setId(id);
		this.setResponsavelSala(responsavelSala);
		this.setNumMaxComputadores(numMaxComputadores);
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
	
	public String getReponsavelSala() {
		return this.responsavelSala;
	}
	
	public void setResponsavelSala(String responsavelSala) {
		if (!responsavelSala.isEmpty() && !responsavelSala.equals(null))
			this.responsavelSala = responsavelSala;
		throw new IllegalArgumentException();
	}
	
	public int getNumMaxComputadores() {
		return this.numMaxComputadores;
	}
	
	public void setNumMaxComputadores(int numMaxComputadores) {
		if (numMaxComputadores > 0)
			this.numMaxComputadores = numMaxComputadores;
		throw new IllegalArgumentException();
	}

	public String getComputadores() {
		String msg = "";
		for (int i = 0; i < computadores.size(); i++) {
			msg += "\n" + computadores.get(i).toString();
		}
		return msg;
	}
	
	public LinkedList<Computador> getComputadoresAsLinkedList() {
		return computadores;
	}

	public Computador getComputadorById(int id) {
		for (int i = 0; i < computadores.size(); i++) {
			if (computadores.get(i).getId() == id) {
				return computadores.get(i);
			}
		}
		return null;
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
