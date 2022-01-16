package vjps.clubedaleitura.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import vjps.clubedaleitura.jdbc.FabricaConexao;
import vjps.clubedaleitura.modelo.Emprestimo;

/**
 * Classe responsável por gerenciar os dados da tabela "emprestimo" do banco de dados "clubedaleitura".
 * @author Vinícius José Pires Silva
 *
 */
public class EmprestimoDAO {

	private Connection connection;
	
	public EmprestimoDAO() {
		connection = FabricaConexao.getConnection();
	}
	
	public void adicionar(Emprestimo emprestimo) {
		String sql = "INSERT INTO emprestimo (idamigo, idrevista, dataemprestimo) VALUES (?, ?, ?)";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, emprestimo.getAmigo().getId());
			stmt.setLong(2, emprestimo.getRevista().getId());
			stmt.setDate(3, new Date(emprestimo.getDataEmprestimo().getTimeInMillis()));
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// adicionar()
	
	public void remover(Emprestimo emprestimo) {
		String sql = "DELETE FROM emprestimo WHERE idemprestimo=?";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, emprestimo.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// remover()
	
	public void alterar(Emprestimo emprestimo) {
		String sql = "UPDATE emprestimo SET idamigo=?, idrevista=?, dataemprestimo=?";
		
		if(emprestimo.getDataDevolucao() != null)
			sql = sql + ", datadevolucao=?";
		
		sql = sql +  " WHERE idemprestimo=?";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, emprestimo.getAmigo().getId());
			stmt.setLong(2, emprestimo.getRevista().getId());
			stmt.setDate(3, new Date(emprestimo.getDataEmprestimo().getTimeInMillis()));
			
			if(emprestimo.getDataDevolucao() != null) {
				stmt.setDate(4, new Date(emprestimo.getDataDevolucao().getTimeInMillis()));
				stmt.setLong(5, emprestimo.getId());
			}else
				stmt.setLong(4, emprestimo.getId());
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// alterar()
	
	/**
	 * Obtém os dados de todos os empréstimos existentes no Banco de Dados.
	 * @return List<Emprestimo> lista com todos os emprestimos.
	 */
	public List<Emprestimo> getListaEmprestimos() {
		List<Emprestimo> emprestimos = new ArrayList<>();
		String sql = "SELECT * FROM emprestimo ORDER BY idemprestimo";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			
			AmigoDAO amigoDao = new AmigoDAO();
			RevistaDAO revistaDao = new RevistaDAO();
			
			while(rs.next()){
				Emprestimo emprestimo = new Emprestimo(rs.getLong("idemprestimo"), 
						amigoDao.getAmigoById(rs.getLong("idamigo")), 
						revistaDao.getRevistaById(rs.getLong("idrevista")), 
						dateToCalendar(rs.getDate("dataemprestimo")), 
						null);
				
				if(rs.getDate("datadevolucao") != null)
					emprestimo.setDataDevolucao(dateToCalendar(rs.getDate("datadevolucao")));
				
				emprestimos.add(emprestimo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emprestimos;
	}// getListaEmprestimos()
	
	/**
	 * Procura no banco de dados um empréstimo com o valor da coluna "idemprestimo" correspondente ao parâmetro "id" informado.
	 * @param id "idemprestimo" do emprestimo.
	 * @return Objeto Emprestimo com os dados ou null caso não exista. 
	 */
	public Emprestimo getEmprestimoById(long id) {
		Emprestimo emprestimo = null;
		String sql = "SELECT * FROM emprestimo WHERE idemprestimo=?";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			AmigoDAO amigoDao = new AmigoDAO();
			RevistaDAO revistaDao = new RevistaDAO();
			
			while(rs.next()) {
				emprestimo = new Emprestimo(rs.getLong("idemprestimo"), 
						amigoDao.getAmigoById(rs.getLong("idamigo")), 
						revistaDao.getRevistaById(rs.getLong("idrevista")), 
						dateToCalendar(rs.getDate("dataemprestimo")), 
						null);
				
				if(rs.getDate("datadevolucao") != null)
					emprestimo.setDataDevolucao(dateToCalendar(rs.getDate("datadevolucao")));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emprestimo;
	}// getListaEmprestimos()
	
	/**
	 * Converte uma data do tipo Date para o Tipo Calendar.
	 * @param date Data
	 * @return Data convertida.
	 */
	private Calendar dateToCalendar(Date date) {
		Calendar data = Calendar.getInstance();
		data.setTime(date);
		return data;
	}
	
}// class EmprestimoDAO







