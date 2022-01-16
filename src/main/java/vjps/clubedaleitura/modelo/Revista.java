package vjps.clubedaleitura.modelo;

/**
 * A classe responsável por gerenciar os dados de uma revista.
 * @author Vinícius José Pires Silva
 */
public class Revista extends Identificador {

	private String colecao;
	private long numeroEdicao;
	private int anoRevista;
	private boolean disponibilidade;
	private Caixa caixa;
	
	public Revista() {
		disponibilidade = true;
	}
	
	public Revista(long id) {
		super(id);
		disponibilidade = true;
	}

	public Revista(String colecao, long numeroEdicao, int anoRevista, Caixa caixa) {
		this();
		this.colecao = colecao;
		this.numeroEdicao = numeroEdicao;
		this.anoRevista = anoRevista;
		this.caixa = caixa;
	}
	
	public Revista(String colecao, long numeroEdicao, int anoRevista, boolean disponibilidade, Caixa caixa) {
		this.colecao = colecao;
		this.numeroEdicao = numeroEdicao;
		this.anoRevista = anoRevista;
		this.disponibilidade = disponibilidade;
		this.caixa = caixa;
	}
	
	public Revista(long id, String colecao, long numeroEdicao, int anoRevista, Caixa caixa) {
		this(id);
		this.colecao = colecao;
		this.numeroEdicao = numeroEdicao;
		this.anoRevista = anoRevista;
		this.caixa = caixa;
	}
	
	public Revista(long id, String colecao, long numeroEdicao, int anoRevista, boolean disponibilidade, Caixa caixa) {
		this(id);
		this.colecao = colecao;
		this.numeroEdicao = numeroEdicao;
		this.anoRevista = anoRevista;
		this.disponibilidade = disponibilidade;
		this.caixa = caixa;
	}

	public String getColecao() {
		return colecao;
	}

	public void setColecao(String colecao) {
		this.colecao = colecao;
	}

	public long getNumeroEdicao() {
		return numeroEdicao;
	}

	public void setNumeroEdicao(long numeroEdicao) {
		this.numeroEdicao = numeroEdicao;
	}

	public int getAnoRevista() {
		return anoRevista;
	}

	public void setAnoRevista(int anoRevista) {
		this.anoRevista = anoRevista;
	}

	public boolean getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(boolean disponibilizade) {
		this.disponibilidade = disponibilizade;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	@Override
	public String toString() {
		return String.format("Revista Edição N° %d\n%s\nColeção: %s\nAno: %d\n%s\n%s disponível", 
					numeroEdicao, super.toString(), colecao, anoRevista, caixa.toString(), (disponibilidade) ? "Está":"Não está");
	}
	
}// class Revista
