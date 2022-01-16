package vjps.clubedaleitura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vjps.clubedaleitura.jdbc.FabricaConexao;
import vjps.clubedaleitura.modelo.Usuario;

/**
 * Classe responsável por gerenciar os dados da tabela "usuario" do banco de dados "clubedaleitura".
 * @author Vinícius José Pires Silva
 *
 */
public class UsuarioDAO {

	private Connection connection;
	
	public UsuarioDAO() {
		connection = FabricaConexao.getConnection();
	}
	
	public void adiciona(Usuario usuario) {
		String sql = "INSERT INTO usuario (usuario, senha) VALUES (?, ?)";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// adiciona()
	
	public void remove(Usuario usuario) {
		String sql = "DELETE FROM usuario WHERE usuario=?";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario.getUsuario());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// remove()
	
	public void altera(Usuario usuario) {
		String sql = "UPDATE usuario SET senha=? WHERE usuario=?";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario.getSenha());
			stmt.setString(2, usuario.getUsuario());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// altera()
	
	public List<Usuario> getListaUsuarios(){
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "SELECT * FROM usuarios";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) 
				usuarios.add(new Usuario(rs.getString("usuario"), rs.getString("senha")));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}// getListaUsuarios()
	
	public Usuario recuperaUsuario (String usuario) {
		String sql = "SELECT * FROM usuario WHERE usuario=?";
		Usuario usuarioRecuperado = null;
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
				usuarioRecuperado = new Usuario(rs.getString("usuario"), rs.getString("senha"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuarioRecuperado;
	}// recuperaUsuario()
	
	public Usuario validaCredencial (String usuario, String senha) {
		String sql = "SELECT * FROM usuario WHERE usuario=? AND senha=?";
		Usuario usuarioValidado = null;
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) 
				usuarioValidado = new Usuario(rs.getString("usuario"), rs.getString("senha"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuarioValidado;
	}// validaCredencial()
	
}// class UsuarioDAO
