package vjps.clubedaleitura.servlet.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vjps.clubedaleitura.dao.RevistaDAO;
import vjps.clubedaleitura.modelo.Caixa;
import vjps.clubedaleitura.modelo.Revista;

/**
 * Classe responsável por tratar e alterar os dados de uma revista no Banco de Dados.
 * @author Vinícius José Pires Silva
 *
 */
public class AlteraRevista implements Logica {

@Override
	public String service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mensagem.jsp";
		Caixa caixa = new Caixa();
		caixa.setId(Long.parseLong(request.getParameter("caixa")));
		
		RevistaDAO revistaDao = new RevistaDAO();
		//Obténdo a revista do BD.
		Revista revista = revistaDao.getRevistaById(Long.parseLong(request.getParameter("id")));
				
		//Atualizando os dados.
		revista.setColecao(request.getParameter("colecao"));		
		revista.setNumeroEdicao(Long.parseLong(request.getParameter("edicao")));
		revista.setAnoRevista(Integer.parseInt(request.getParameter("ano")));
		revista.setCaixa(caixa);
		
		//Salvando as alterações no BD.
		revistaDao.alterar(revista);
		
		request.setAttribute("mensagem", String.format("Dados da revista %s - N° %d alterados com sucesso!", revista.getColecao(), revista.getNumeroEdicao()));
		return url;
	}	
	
}// class AlteraRevista
