package vjps.clubedaleitura.servlet.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vjps.clubedaleitura.servlet.logica.Logica;

/**
 * Classe responsável por controlar todas as demais servlets da aplicação.
 * 
 * @author Vinícius José Pires Silva
 *
 */
@WebServlet("/controle")
public class ControladoraServlet extends HttpServlet {

	@SuppressWarnings({ "rawtypes", "deprecation" })
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeClasse = "vjps.clubedaleitura.servlet.logica." + request.getParameter("logica");
		
		Class classe;
		String url = "menuPrincipal.jsp";
		
		try {
			classe = Class.forName(nomeClasse);
			
			Logica logica = (Logica) classe.newInstance();
			
			url = logica.service(request, response);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (InstantiationException e) {
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher(url).forward(request, response);
	}// service()

}// class ControladoraServlet
