package vjps.clubedaleitura.servlet.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vjps.clubedaleitura.dao.AmigoDAO;
import vjps.clubedaleitura.dao.EmprestimoDAO;
import vjps.clubedaleitura.dao.RevistaDAO;
import vjps.clubedaleitura.modelo.Amigo;
import vjps.clubedaleitura.modelo.Emprestimo;

/**
 * Classe responsável por remover os dados de um amigo do Banco de Dados.
 * @author Vinícius José Pires Silva
 *
 */
public class RemoveAmigo implements Logica{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String url = "mensagem.jsp";
		
		Amigo amigo = new Amigo();
		amigo.setId(Long.parseLong(request.getParameter("id")));
		
		//Verifica se o amigo possui alguma pendência (revista emprestada) e realiza a devolução da mesma.
		AmigoDAO dao = new AmigoDAO();
		long pendencia = dao.verificaPendencia(amigo);
		if(pendencia != -1L) {
			EmprestimoDAO emprestimoDao = new EmprestimoDAO();
			Emprestimo emprestimo = emprestimoDao.getEmprestimoById(pendencia);
			
			RevistaDAO revistaDAO = new RevistaDAO();
			revistaDAO.alterarDisponibilidade(emprestimo.getRevista().getId());
		}
			
		//Remove o amigo.
		dao.remover(amigo);
		
		request.setAttribute("mensagem", "Amigo removido com sucesso!");
		
		return url;
	}
	
}// class RemoveAmigo
