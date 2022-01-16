package vjps.clubedaleitura.modelo;

/**
 * Classe abstrata responsável por identificar os objetos com um ID.
 * @author Vinícius José Pires Silva
 */
public abstract class Identificador {
	
	private long id;
	
	public Identificador() {
	}

	public Identificador(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("ID: %d", id);
	}
	
}// abstract class Identificador 
