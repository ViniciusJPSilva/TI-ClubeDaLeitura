package vjps.clubedaleitura.modelo;

/**
 * Classe responsável por gerenciar os dados de uma caixa.
 * @author Vinícius José Pires Silva
 *
 */
public class Caixa extends Identificador {

	private String cor;
	
	public Caixa() {
	}

	public Caixa(String cor) {
		this.cor = cor;
	}

	public Caixa(long id, String cor) {
		super(id);
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return String.format("Caixa %d - Cor: %s", getId(), cor);
	}
	
}// class Caixa
