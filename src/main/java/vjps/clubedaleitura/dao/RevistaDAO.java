package vjps.clubedaleitura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vjps.clubedaleitura.jdbc.FabricaConexao;
import vjps.clubedaleitura.modelo.Revista;

/**
 * Classe responsável por gerenciar os dados da tabela "revista" do banco de dados "clubedaleitura".
 * @author Vinícius José Pires Silva
 *
 */
public class RevistaDAO {

	private Connection connection;
	
	public RevistaDAO() {
		connection = FabricaConexao.getConnection();
	}
	
	/**
	 * Adiciona os dados de uma nova revista ao Banco de Dados.
	 * @param revista Revista.
	 */
	public void adicionar(Revista revista) {
		String sql = "INSERT INTO revista (colecao, \"num-edicao\", \"ano-revista\", disponibilidade, idcaixa) VALUES (?, ?, ?, ?, ?)";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, revista.getColecao());
			stmt.setLong(2, revista.getNumeroEdicao());
			stmt.setInt(3, revista.getAnoRevista());
			stmt.setBoolean(4, revista.getDisponibilidade());
			stmt.setLong(5, revista.getCaixa().getId());
			
			stmt.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}// adiciona()
	
	/**
	 * Remove os dados de uma revista do Banco de Dados.
	 * @param revista Revista.
	 */
	public void remover(Revista revista) {
		String sql = "DELETE FROM revista WHERE idrevista=?";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, revista.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// remove()
	
	/**
	 * Altera os dados de uma revista do Banco de Dados.
	 * @param revista Revista.
	 */
	public void alterar(Revista revista) {
		String sql = "UPDATE revista SET colecao=?, \"num-edicao\"=?, \"ano-revista\"=?, disponibilidade=?, idcaixa=? WHERE idrevista=?";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, revista.getColecao());
			stmt.setLong(2, revista.getNumeroEdicao());
			stmt.setInt(3, revista.getAnoRevista());
			stmt.setBoolean(4, revista.getDisponibilidade());
			stmt.setLong(5, revista.getCaixa().getId());
			stmt.setLong(6, revista.getId());
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// altera()
	
	/**
	 * Obtém os dados de todos as revistas existentes no Banco de Dados.
	 * @return List<Revista> lista com todos as revistas.
	 */
	public List<Revista> getListaRevistas(){
		List<Revista> revistas = new ArrayList<>();
		String sql = "SELECT * FROM revista ORDER BY idrevista";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			CaixaDAO caixaDao = new CaixaDAO();
			
			while(rs.next())
				revistas.add(new Revista(rs.getLong("idrevista"), rs.getString("colecao"), rs.getLong("num-edicao"), rs.getInt("ano-revista"), rs.getBoolean("disponibilidade"), caixaDao.getCaixaById(rs.getLong("idcaixa"))));
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return revistas;
	}// getListaUsuarios()
	
	/**
	 * Procura no banco de dados uma revista com o valor da coluna "idrevista" correspondente ao parâmetro "id" informado.
	 * @param id "idrevista" da revista.
	 * @return Objeto revista com os dados ou null caso não exista. 
	 */
	public Revista getRevistaById(long id) {
		String sql = "SELECT * FROM revista WHERE idrevista=?";
		Revista revista = null;
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			CaixaDAO caixaDao = new CaixaDAO();
			
			while(rs.next())
				revista = new Revista(rs.getLong("idrevista"), rs.getString("colecao"), rs.getLong("num-edicao"), rs.getInt("ano-revista"), rs.getBoolean("disponibilidade"), caixaDao.getCaixaById(rs.getLong("idcaixa")));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return revista;
	}// getRevistaById()
	
	/**
	 * Altera a coluna "disponibilidade" de uma revista no Banco de Dados.
	 * True -> False ou False -> True
	 * @param id Id da revista.
	 */
	public void alterarDisponibilidade(Long id) {
		String sql = "UPDATE revista SET disponibilidade=? WHERE idrevista=?";
		Revista revista = getRevistaById(id);
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setBoolean(1, !revista.getDisponibilidade());
			stmt.setLong(2, id);
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// alterarDisponibilidade()
	
}// class RevistaDAO
