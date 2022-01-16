package vjps.clubedaleitura.servlet.logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vjps.clubedaleitura.dao.EmprestimoDAO;
import vjps.clubedaleitura.modelo.Emprestimo;

/**
 * Classe responsável por gerar uma lista de empréstimos em atraso.
 * @author Vinícius José Pires Silva
 *
 */
public class AtrasosEmprestimo implements Logica {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "lista-emprestimos-atraso.jsp";
		
		EmprestimoDAO emprestimoDao = new EmprestimoDAO();
		
		List<Emprestimo> emprestimosAtraso = new ArrayList<>(),
				emprestimos = emprestimoDao.getListaEmprestimos();
		
		for(Emprestimo emprestimo : emprestimos) {
			//Verifica se o emprestimo está pendente.
			if(emprestimo.getDataDevolucao() == null) {
				//Soma 10 dias à data de empréstimo para definir a data de devolução.
				Calendar dataDevolucao = new GregorianCalendar();
				dataDevolucao.setTime(emprestimo.getDataEmprestimo().getTime());
				dataDevolucao.add(Calendar.DAY_OF_YEAR, 10);
				
				//Data atual do sistema, para comparações.
				Calendar dataAtual = Calendar.getInstance();
				dataAtual.setTime(new Date());
				
				//Verifica se há atraso.
				if(dataAtual.compareTo(dataDevolucao) == 1) {
					emprestimo.setDataDevolucao(dataDevolucao);
					emprestimosAtraso.add(emprestimo);
				}
			}
		}
		
		request.setAttribute("emprestimosAtraso", emprestimosAtraso);
		return url;
	}
	
}// class AtrasosEmprestimo
