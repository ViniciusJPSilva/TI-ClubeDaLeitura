package vjps.clubedaleitura.servlet.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vjps.clubedaleitura.dao.CaixaDAO;
import vjps.clubedaleitura.modelo.Caixa;

/**
 * Classe responsável por remover os dados de uma caixa do Banco de Dados.
 * @author Vinícius José Pires Silva
 *
 */
public class RemoveCaixa implements Logica {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		String url = "mensagem.jsp";
		
		Caixa caixa = new Caixa();
		caixa.setId(Long.parseLong(request.getParameter("id")));
		
		CaixaDAO dao = new CaixaDAO();
		dao.remover(caixa);
		
		request.setAttribute("mensagem", "Caixa removida com sucesso!");
		return url;
	}
	
}// class RemoveCaixa
