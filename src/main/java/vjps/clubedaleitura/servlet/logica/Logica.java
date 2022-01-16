package vjps.clubedaleitura.servlet.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface responsável por organizar as Servlets Lógicas do sistema.
 * @author Vinícius José Pires Silva
 *
 */
public interface Logica{

	public String service (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;

}// interface Logica
