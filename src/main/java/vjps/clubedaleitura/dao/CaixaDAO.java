package vjps.clubedaleitura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vjps.clubedaleitura.jdbc.FabricaConexao;
import vjps.clubedaleitura.modelo.Caixa;

/**
 * Classe responsável por gerenciar os dados da tabela "caixa" do banco de dados "clubedaleitura".
 * @author Vinícius José Pires Silva
 *
 */
public class CaixaDAO {

	private Connection connection;
	
	public CaixaDAO() {
		connection = FabricaConexao.getConnection();
	}
	
	/**
	 * Adiciona os dados de uma nova caixa ao Banco de Dados.
	 * @param caixa Caixa.
	 */
	public void adicionar(Caixa caixa) {
		String sql = "INSERT INTO caixa (cor) VALUES (?)";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, caixa.getCor());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// adiciona()
	
	/**
	 * Remove os dados de uma caixa do Banco de Dados.
	 * @param caixa Caixa.
	 */
	public void remover(Caixa caixa) {
		String sql = "DELETE FROM caixa WHERE idcaixa=?";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, caixa.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// remove()
	
	/**
	 * Altera os dados de uma caixa do Banco de Dados.
	 * @param caixa Caixa.
	 */
	public void alterar(Caixa caixa) {
		String sql = "UPDATE caixa SET cor=? WHERE idcaixa=?";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, caixa.getCor());
			stmt.setLong(2, caixa.getId());
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// altera()
	
	/**
	 * Obtém os dados de todos as caixas existentes no Banco de Dados.
	 * @return List<Caixa> lista com todos as Caixas.
	 */
	public List<Caixa> getListaCaixas(){
		List<Caixa> caixas = new ArrayList<>();
		String sql = "SELECT * FROM caixa ORDER BY cor";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
				caixas.add(new Caixa(rs.getLong("idcaixa"), rs.getString("cor")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return caixas;
	}// getListaCaixas()
	
	/**
	 * Procura no banco de dados uma caixa com o valor da coluna "idcaixa" correspondente ao parâmetro "id" informado.
	 * @param id "idcaixa" da caixa.
	 * @return Caixa Objeto Caixa com os dados ou null caso não exista. 
	 */
	public Caixa getCaixaById(long id) {
		String sql = "SELECT * FROM caixa WHERE idcaixa=?";
		Caixa caixa = null;
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
				caixa = new Caixa(rs.getLong("idcaixa"), rs.getString("cor"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return caixa;
	}// getCaixaById()
	
	/**
	 * Procura no banco de dados uma caixa com o valor da coluna "cor" correspondente ao parâmetro "cor" informado.
	 * @param cor String "cor" da caixa.
	 * @return Caixa Objeto Caixa com os dados ou null caso não exista. 
	 */
	public Caixa getCaixaByCor(String cor) {
		String sql = "SELECT * FROM caixa WHERE cor=?";
		Caixa caixa = null;
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cor);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
				caixa = new Caixa(rs.getLong("idcaixa"), rs.getString("cor"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return caixa;
	}// getCaixaById()
	
}// class CaixaDAO
