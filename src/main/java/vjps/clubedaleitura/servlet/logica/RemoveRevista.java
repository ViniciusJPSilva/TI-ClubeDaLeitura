package vjps.clubedaleitura.servlet.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vjps.clubedaleitura.dao.RevistaDAO;
import vjps.clubedaleitura.modelo.Revista;

/**
 * Classe responsável por remover os dados de uma revista do Banco de Dados.
 * @author Vinícius José Pires Silva
 *
 */
public class RemoveRevista implements Logica {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String url = "mensagem.jsp";
		
		Revista revista = new Revista();
		revista.setId(Long.parseLong(request.getParameter("id")));
		
		RevistaDAO dao = new RevistaDAO();
		dao.remover(revista);
		
		request.setAttribute("mensagem", "Revista removida com sucesso!");
		return url;
	}
	
}// class RemoveRevista
