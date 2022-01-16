package vjps.clubedaleitura.modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Classe responsável por gerenciar os dados de um empréstimo.
 * @author Vinícius José Pires Silva
 */
public class Emprestimo extends Identificador {

	private Amigo amigo;
	private Revista revista;
	
	private Calendar dataEmprestimo, dataDevolucao;
	
	public final String DATA_NAO_ESPECIFICADA = "Data não especificada";
	
	public Emprestimo() {
	}

	public Emprestimo(long id) {
		super(id);
	}

	public Emprestimo(Amigo amigo, Revista revista, Calendar dataEmprestimo, Calendar dataDevolucao) {
		this.amigo = amigo;
		this.revista = revista;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}
	
	public Emprestimo(long id, Amigo amigo, Revista revista, Calendar dataEmprestimo, Calendar dataDevolucao) {
		this(id);
		this.amigo = amigo;
		this.revista = revista;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}

	public Amigo getAmigo() {
		return amigo;
	}

	public void setAmigo(Amigo amigo) {
		this.amigo = amigo;
	}

	public Revista getRevista() {
		return revista;
	}

	public void setRevista(Revista revista) {
		this.revista = revista;
	}

	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Calendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	@Override
	public String toString() {
		DateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
		String strDataEmprestimo = (dataEmprestimo != null) ? formatarData.format(dataEmprestimo.getTime()) : DATA_NAO_ESPECIFICADA;
		String strDataDevolucao = (dataDevolucao != null) ? formatarData.format(dataDevolucao.getTime()) : DATA_NAO_ESPECIFICADA;
				
				
		return String.format("Emprestimo %d - Amigo: %s - Revista: %s N°%d - Data emprestimo: %s - Data devolução: %s", 
						getId(), amigo.getNome(), revista.getColecao(), revista.getNumeroEdicao(), strDataEmprestimo, strDataDevolucao);
	}
	
	public String getInformacoes() {
		return toString();
	}

}// class Emprestimo
