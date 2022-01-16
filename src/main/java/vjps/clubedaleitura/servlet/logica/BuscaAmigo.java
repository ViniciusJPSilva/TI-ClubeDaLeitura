package vjps.clubedaleitura.servlet.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vjps.clubedaleitura.dao.AmigoDAO;
import vjps.clubedaleitura.modelo.Amigo;

/**
 * Classe responsável por recuperar os dados de um amigo do Banco de Dados.
 * @author Vinícius José Pires Silva
 *
 */
public class BuscaAmigo implements Logica{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

		String url = request.getParameter("redireciona");
		
		AmigoDAO amigoDao = new AmigoDAO();
		Amigo amigo = amigoDao.getAmigoById(Long.parseLong(request.getParameter("id")));
		
		request.setAttribute("amigo", amigo);
		
		return url;
	}
	
}// class BuscaAmigo
