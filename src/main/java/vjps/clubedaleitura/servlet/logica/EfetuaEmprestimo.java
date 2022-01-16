package vjps.clubedaleitura.servlet.logica;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vjps.clubedaleitura.dao.EmprestimoDAO;
import vjps.clubedaleitura.dao.RevistaDAO;
import vjps.clubedaleitura.modelo.Amigo;
import vjps.clubedaleitura.modelo.Emprestimo;
import vjps.clubedaleitura.modelo.Revista;

/**
 * Classe responsável por adicionar um novo empréstimo ao Banco de Dados e realizar todas as alterações necessárias nos objetos dependentes.
 * @author Vinícius José Pires Silva
 *
 */
public class EfetuaEmprestimo implements Logica{
	
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Amigo amigo = new Amigo();
		amigo.setId(Long.parseLong(request.getParameter("amigo")));
		
		Revista	revista = new Revista();
		revista.setId(Long.parseLong(request.getParameter("revista")));
		
		String url = "mensagem.jsp",
				mensagem = "Empréstimo efetuado com sucesso!";
		
		try {
			//Convertendo as datas de String para Calendar
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataEmprestimo = new GregorianCalendar();
			dataEmprestimo.setTime(df.parse(request.getParameter("dataEmprestimo"))); 
		
			//Data atual do sistema, para comparações.
			Calendar dataAtual = Calendar.getInstance();
			dataAtual.setTime(new Date());
			
			//Evita que a data de empréstimo seja maior que a data atual.
			if(dataEmprestimo.compareTo(dataAtual) == 1) 
				throw new Exception();
			
			//Adicionando o empréstimo ao BD.
			EmprestimoDAO dao = new EmprestimoDAO();
			dao.adicionar(new Emprestimo(amigo, revista, dataEmprestimo, null));
			
			//Alterando a disponibilidade da revista emprestada.
			RevistaDAO revistaDao = new RevistaDAO();
			revistaDao.alterarDisponibilidade(revista.getId());
		} catch (Exception e) {
			mensagem = "Ocorreu um erro!\nA data de empréstimo deve ser menor ou igual à data atual e seguir o seguinte modelo DD/MM/AAAA.";
		}
		
		request.setAttribute("mensagem", mensagem);
		return url;
	}
	
}// class EfetuaEmprestimo
