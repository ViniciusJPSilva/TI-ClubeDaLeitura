package vjps.clubedaleitura.servlet.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Classe responsável por efetuar o Logout do usuário.
 * @author Vinícius José Pires Silva
 *
 */
public class EfetuaLogout implements Logica {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Recupera a sessão já existente.
		HttpSession sessao = request.getSession();
		sessao.invalidate();
		
		return "login.jsp";
	}
	
}
