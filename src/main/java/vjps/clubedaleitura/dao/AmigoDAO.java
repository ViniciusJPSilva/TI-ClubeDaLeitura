package vjps.clubedaleitura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vjps.clubedaleitura.jdbc.FabricaConexao;
import vjps.clubedaleitura.modelo.Amigo;

/**
 * Classe responsável por gerenciar os dados da tabela "amigo" do banco de dados "clubedaleitura".
 * @author Vinícius José Pires Silva
 *
 */
public class AmigoDAO {

	private Connection connection;
	
	public AmigoDAO() {
		connection = FabricaConexao.getConnection();
	}
	
	/**
	 * Adiciona os dados de um novo amigo ao Banco de Dados.
	 * @param amigo Amigo 
	 */
	public void adicionar(Amigo amigo) {
		String sql = "INSERT INTO amigo (nome, telefone) VALUES (?, ?)";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, amigo.getNome());
			stmt.setString(2, amigo.getTelefone());
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// adicionar()
	
	/**
	 * Remove os dados de um amigo do Banco de Dados.
	 * @param amigo Amigo
	 */
	public void remover(Amigo amigo) {
		String sql = "DELETE FROM amigo WHERE idamigo=?";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, amigo.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// remover()
	
	/**
	 * Altera os dados de um amigo do Banco de Dados.
	 * @param amigo Amigo
	 */
	public void alterar(Amigo amigo) {
		String sql = "UPDATE amigo SET nome=?, telefone=? WHERE idamigo=?";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, amigo.getNome());
			stmt.setString(2, amigo.getTelefone());
			stmt.setLong(3, amigo.getId());
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// alterar()
	
	/**
	 * Obtém os dados de todos os amigos existentes no Banco de Dados.
	 * @return List<Amigo> lista com todos os amigos.
	 */
	public List<Amigo> getListaAmigos(){
		List<Amigo> amigos = new ArrayList<>();
		String sql = "SELECT * FROM amigo ORDER BY nome";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
				amigos.add(new Amigo(rs.getLong("idamigo"), rs.getString("nome"), rs.getString("telefone")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return amigos;
	}// getListaAmigos()
	
	/**
	 * Procura no banco de dados um amigo com o valor da coluna "idamigo" correspondente ao parâmetro "id" informado.
	 * @param id "idamigo" do amigo.
	 * @return Objeto Amigo com os dados ou null caso não exista. 
	 */
	public Amigo getAmigoById(long id) {
		String sql = "SELECT * FROM amigo WHERE idamigo=?";
		Amigo amigo = null;
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
				amigo = new Amigo(rs.getLong("idamigo"), rs.getString("nome"), rs.getString("telefone"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return amigo;
	}// getAmigoById()
	
	/**
	 * Pesquisa no BD e retorna uma lista com todos os amigos que não possuem pendências.
	 * @return List<Amigos> amigos sem pendência.
	 */
	public List<Amigo> getListaAmigosSemPendencia(){
		List<Amigo> amigosSemPendencia = new ArrayList<>(),
				amigos = getListaAmigos();
		
		for(Amigo amigo : amigos)
			if(verificaPendencia(amigo) == -1L)
				amigosSemPendencia.add(amigo);
		
		return amigosSemPendencia;
	}// getListaAmigos()
	
	/**
	 * Verifica se o amigo possui algum emprestimo pendente.
	 * @param amigo amigo
	 * @return id do emprestimo pendente ou -1 caso não haja nenhum.
	 */
	public long verificaPendencia(Amigo amigo) {
		String sql = "SELECT * FROM emprestimo WHERE idamigo=?";
				
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, amigo.getId());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
				if(rs.getDate("datadevolucao") == null)
					return rs.getLong("idemprestimo");
		} catch (SQLException e) {
			e.printStackTrace();
		}		

		return -1;
	}// verificaPendencia()
	
}// class AmigoDAO
