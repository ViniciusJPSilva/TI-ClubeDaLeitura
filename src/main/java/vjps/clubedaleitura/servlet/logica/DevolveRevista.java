package vjps.clubedaleitura.servlet.logica;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vjps.clubedaleitura.dao.EmprestimoDAO;
import vjps.clubedaleitura.dao.RevistaDAO;
import vjps.clubedaleitura.modelo.Emprestimo;

/**
 * Classe responsável por realizar a devolução de uma revista e finalizar o empréstimo da mesma.
 * @author Vinícius José Pires Silva
 *
 */
public class DevolveRevista implements Logica{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		String url = "lista-revistas-emprestadas.jsp";
		
		EmprestimoDAO emprestimoDao = new EmprestimoDAO();
		Emprestimo emprestimo = emprestimoDao.getEmprestimoById(Long.parseLong(request.getParameter("idEmprestimo")));
		
		try {
			//Data atual do sistema, para devolução.
			Calendar dataAtual = Calendar.getInstance();
			dataAtual.setTime(new Date());
		
			//Adicionando a data de devolução ao empréstimo.
			emprestimo.setDataDevolucao(dataAtual);
		
		} catch (Exception e) {
			url = "erro.jsp";
		}
		
		//Alterando a disponibilidade da revista emprestada.
		RevistaDAO revistaDao = new RevistaDAO();
		revistaDao.alterarDisponibilidade(emprestimo.getRevista().getId());
		
		//Salvando as alterações no banco de dados.
		emprestimoDao.alterar(emprestimo);
		
		return url;
	
	}
	
}// class DevolveRevista
