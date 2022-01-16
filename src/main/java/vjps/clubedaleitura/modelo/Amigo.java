package vjps.clubedaleitura.modelo;

/**
 * Classe responsável por gerenciar os dados de um amigo.
 * @author Vinícius José Pires Silva
 */
public class Amigo extends Identificador {

	private String nome, telefone;
	
	public Amigo() {
	}

	public Amigo(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}

	public Amigo(long id, String nome, String telefone) {
		super(id);
		this.nome = nome;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return String.format("Amigo %s\n%s\nTelefone: %s", nome, super.toString(), telefone);
	}

}// class Amigo
