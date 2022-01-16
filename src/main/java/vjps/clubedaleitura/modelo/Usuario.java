package vjps.clubedaleitura.modelo;

/**
 * Classe responsável por gerenciar os dados de um usuário.
 * @author Vinícius José Pires Silva
 */
public class Usuario extends Identificador {

	private String usuario, senha;
	
	public Usuario() {
	}
	
	public Usuario(long id) {
		super(id);
	}

	public Usuario(String login, String senha) {
		this.usuario = login;
		this.senha = senha;
	}
	
	public Usuario(long id, String login, String senha) {
		this(id);
		this.usuario = login;
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String login) {
		this.usuario = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return String.format("Usuário %s\n%s", usuario, super.toString());
	}
	
}// class Usuario
