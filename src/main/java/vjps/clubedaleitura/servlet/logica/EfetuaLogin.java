package vjps.clubedaleitura.servlet.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vjps.clubedaleitura.dao.UsuarioDAO;
import vjps.clubedaleitura.modelo.Usuario;

/**
 * Classe responsável por validar os dados de Login do usuário.
 * @author Vinícius José Pires Silva
 *
 */
public class EfetuaLogin implements Logica {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String usuario = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		String url = "login.jsp";
		
		UsuarioDAO userDao = new UsuarioDAO();
		Usuario user = userDao.validaCredencial(usuario, senha);
		
		if(user != null) {
			//Recupera Sessão
			HttpSession sessao = request.getSession();
			
			//Define o tempo de atividade da sessão (em segundos)
			sessao.setMaxInactiveInterval(2*60);
			sessao.setAttribute("status", true);
			sessao.setAttribute("nome", usuario);
			
			url = "menuPrincipal.jsp";
		}
		
		return url;
	}

}// class EfetuaLogin
