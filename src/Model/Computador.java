package Model;

import java.util.ArrayList;

public class Computador {
	private int id;
	private String modelo;
	private String marca;
	private ArrayList<String> defeitos = new ArrayList<String>();
	private Sala sala;
	private int session;

	public Computador(String modelo, String marca, int id) {
		super();
		this.setModelo(modelo);
		this.setMarca(marca);
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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		if (modelo.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if (marca.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.marca = marca;
	}

	public ArrayList<String> getDefeitos() {
		return defeitos;
	}

	public void addDefeitos(String defeito) {
		if (!defeito.isEmpty()) {
			defeitos.add(defeito);
		}
	}

	public void removeDefeitos(int id) {
		if (id >= 0 && id < defeitos.size()) {
			defeitos.remove(id);
		}
	}

	public int getSession() {
		return session;
	}

	public void setSession(int session) {
		if (session < 0) {
			this.session = session;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		if (sala == null) {
			throw new IllegalArgumentException();
		}
		this.sala = sala;
	}

}
