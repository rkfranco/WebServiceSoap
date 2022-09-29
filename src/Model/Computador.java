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
			throw new IllegalArgumentException("Id informado deve ser maior que 0");
		}
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		if (modelo.equals(null) || modelo.isEmpty()) {
			throw new IllegalArgumentException("Modelo informado nulo ou invalido");
		}
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if (marca.equals(null) || marca.isEmpty()) {
			throw new IllegalArgumentException("Marca informada nula ou invalida");
		}
		this.marca = marca;
	}

	public ArrayList<String> getDefeitos() {
		return defeitos;
	}

	public String getStringDefeitos() {
		if (defeitos.size() == 0)
			return "N�o h� defeitos";
		String msg = "";
		for (String def : defeitos) {
			msg += "\n" + def;
		}
		return msg;
	}

	public void addDefeitos(String defeito) {
		if (!(defeito.equals(null) || defeito.isEmpty())) {
			defeitos.add(defeito);
		}
	}

	public void removeDefeitos() {
		this.defeitos = new ArrayList<String>();
	}

	public int getSession() {
		return session;
	}

	public void setSession(int session) {
		if (session >= 0) {
			this.session = session;
		} else {
			throw new IllegalArgumentException("Sessao informada deve ser maior que 0");
		}
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		if (sala == null) {
			throw new IllegalArgumentException("Sala informada nula ou invalida");
		}
		this.sala = sala;
	}

	@Override
	public String toString() {
		return "modelo: " + this.modelo + " | marca: " + this.marca + " | se��o: " + this.session + " | id: " + this.id
				+ "\ndefeitos: " + this.getStringDefeitos();
	}
}
