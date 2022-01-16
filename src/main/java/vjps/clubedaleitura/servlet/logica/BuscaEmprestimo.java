package vjps.clubedaleitura.servlet.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vjps.clubedaleitura.dao.EmprestimoDAO;
import vjps.clubedaleitura.modelo.Emprestimo;

/**
 * Classe responsável por recuperar os dados de um empréstimo do Banco de Dados.
 * @author Vinícius José Pires Silva
 *
 */
public class BuscaEmprestimo implements Logica{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String url = request.getParameter("redireciona");
	
		long idEmprestimo = Long.parseLong(request.getParameter("id"));
		
		EmprestimoDAO emprestimoDao = new EmprestimoDAO();
		Emprestimo emprestimo = emprestimoDao.getEmprestimoById(idEmprestimo);

		request.setAttribute("emprestimo", emprestimo);		
				
		return url;
	}
	
}// class BuscaEmprestimo
