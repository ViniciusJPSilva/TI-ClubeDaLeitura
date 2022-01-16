package vjps.clubedaleitura.servlet.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vjps.clubedaleitura.dao.CaixaDAO;
import vjps.clubedaleitura.dao.RevistaDAO;
import vjps.clubedaleitura.modelo.Revista;

/**
 * Classe responsável por adicionar uma nova revista ao Banco de Dados.
 * @author Vinícius José Pires Silva
 *
 */
public class CadastraRevista implements Logica {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "mensagem.jsp";
		CaixaDAO caixaDao = new CaixaDAO();
		
		Revista revista = new Revista(
				request.getParameter("colecao"), 
				Long.parseLong(request.getParameter("edicao")), 
				Integer.parseInt(request.getParameter("ano")), 
				true, 
				caixaDao.getCaixaById(Long.parseLong(request.getParameter("caixa"))));
		
		try {
			RevistaDAO dao = new RevistaDAO();
			dao.adicionar(revista);
		}catch (Exception e) {
			url = "erro.jsp";
		}

		request.setAttribute("mensagem", String.format("Revista %s - N° %d cadastrada com sucesso!", revista.getColecao(), revista.getNumeroEdicao()));
		return url;
	}

}// class CadastraRevista
