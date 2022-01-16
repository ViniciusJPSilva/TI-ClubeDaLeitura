package vjps.clubedaleitura.servlet.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vjps.clubedaleitura.dao.CaixaDAO;
import vjps.clubedaleitura.modelo.Caixa;

/**
 * Classe responsável por tratar e alterar os dados de uma caixa no Banco de Dados.
 * @author Vinícius José Pires Silva
 *
 */
public class AlteraCaixa implements Logica{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String url = "mensagem.jsp";
		
		Caixa caixa = new Caixa(
				Long.parseLong(request.getParameter("id")),
				request.getParameter("cor"));
		
		CaixaDAO dao = new CaixaDAO();
		dao.alterar(caixa);
		
		request.setAttribute("mensagem", String.format("Dados da caixa %s alterados com sucesso!", caixa.getCor()));
		return url;
	}
	
}// class AlteraCaixa
