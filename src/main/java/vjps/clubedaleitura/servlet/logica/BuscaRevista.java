package vjps.clubedaleitura.servlet.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vjps.clubedaleitura.dao.RevistaDAO;
import vjps.clubedaleitura.modelo.Revista;

/**
 * Classe responsável por recuperar os dados de uma revista do Banco de Dados.
 * @author Vinícius José Pires Silva
 *
 */
public class BuscaRevista implements Logica {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("redireciona");
		
		RevistaDAO revistaDao = new RevistaDAO();
		Revista revista = revistaDao.getRevistaById(Long.parseLong(request.getParameter("id")));
		
		request.setAttribute("revista", revista);
		
		return url;
	}// service()
	
}// class BuscaRevista
