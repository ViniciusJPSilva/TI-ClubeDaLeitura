package vjps.clubedaleitura.servlet.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vjps.clubedaleitura.dao.EmprestimoDAO;
import vjps.clubedaleitura.dao.RevistaDAO;
import vjps.clubedaleitura.modelo.Emprestimo;

/**
 * Classe responsável por remover os dados de um empréstimo do Banco de Dados.
 * @author Vinícius José Pires Silva
 *
 */
public class RemoveEmprestimo implements Logica {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String url = "mensagem.jsp";
		
		EmprestimoDAO emprestimoDao = new EmprestimoDAO();
		Emprestimo emprestimo = emprestimoDao.getEmprestimoById(Long.parseLong(request.getParameter("id")));
		
		//Verifica se o emprestimo está pendente.
		//Caso esteja, realiza a devolução da revista emprestada.
		if(emprestimo.getDataDevolucao() == null) {
			RevistaDAO revistaDao = new RevistaDAO();
			revistaDao.alterarDisponibilidade(emprestimo.getRevista().getId());
		}
		
		emprestimoDao.remover(emprestimo);
		
		request.setAttribute("mensagem", String.format("Empréstimo %d removido com sucesso!", emprestimo.getId()));
		return url;
	}
	
}// class RemoveEmprestimo
