package vjps.clubedaleitura.servlet.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vjps.clubedaleitura.dao.AmigoDAO;
import vjps.clubedaleitura.modelo.Amigo;

/**
 * Classe responsável por tratar e alterar os dados de um amigo no Banco de Dados.
 * @author Vinícius José Pires Silva
 *
 */
public class AlteraAmigo implements Logica {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

		String url = "mensagem.jsp";
		
		Amigo amigo = new Amigo(
				Long.parseLong(request.getParameter("id")),
				request.getParameter("nome"),
				request.getParameter("telefone"));
		
		AmigoDAO dao = new AmigoDAO();
		dao.alterar(amigo);
		
		
		request.setAttribute("mensagem", String.format("Dados do amigo %s alterados com sucesso!", amigo.getNome()));
		return url;
		
	}
	
}// class AlteraAmigo
