package vjps.clubedaleitura.servlet.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vjps.clubedaleitura.dao.AmigoDAO;
import vjps.clubedaleitura.modelo.Amigo;

/**
 * Classe responsável por adicionar um novo amigo ao Banco de Dados.
 * @author Vinícius José Pires Silva
 *
 */
public class CadastraAmigo implements Logica {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Amigo amigo = new Amigo(request.getParameter("nome"), request.getParameter("telefone"));
		String url = "mensagem.jsp";
		
		try {
			AmigoDAO dao = new AmigoDAO();
			
			dao.adicionar(amigo);
		}catch (Exception e) {
			url = "erro.jsp";
		}
	
		request.setAttribute("mensagem", String.format("Amigo %s cadastrado com sucesso!", amigo.getNome()));
		return url;
	}
	
}// class CadastrarAmigo
