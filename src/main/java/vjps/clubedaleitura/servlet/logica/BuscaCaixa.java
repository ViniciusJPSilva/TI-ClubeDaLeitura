package vjps.clubedaleitura.servlet.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vjps.clubedaleitura.dao.CaixaDAO;
import vjps.clubedaleitura.modelo.Caixa;

/**
 * Classe responsável por recuperar os dados de uma caixa do Banco de Dados.
 * @author Vinícius José Pires Silva
 *
 */
public class BuscaCaixa implements Logica {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String url = request.getParameter("redireciona");
		
		CaixaDAO caixaDao = new CaixaDAO();
		Caixa caixa = caixaDao.getCaixaById(Long.parseLong(request.getParameter("id")));
		
		request.setAttribute("caixa", caixa);
		
		return url;
	}
	
}// class BuscaCaixa
