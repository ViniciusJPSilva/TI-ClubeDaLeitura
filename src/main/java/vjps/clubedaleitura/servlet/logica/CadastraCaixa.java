package vjps.clubedaleitura.servlet.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vjps.clubedaleitura.dao.CaixaDAO;
import vjps.clubedaleitura.modelo.Caixa;

/**
 * Classe responsável por adicionar uma nova caixa ao Banco de Dados.
 * @author Vinícius José Pires Silva
 *
 */
public class CadastraCaixa implements Logica{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mensagem.jsp";
		Caixa caixa = new Caixa(request.getParameter("cor"));
		
		try {
			CaixaDAO dao = new CaixaDAO();
			dao.adicionar(caixa);
		} catch (Exception e) {
			url = "erro.jsp";
		}
		
		request.setAttribute("mensagem", String.format("Caixa %s cadastrada com sucesso!", caixa.getCor()));
		return url;
	}
	
}// class CadastraCaixa
