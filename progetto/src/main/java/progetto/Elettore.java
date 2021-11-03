package progetto;

public class Elettore {
	
	private String nome;
	private String cognome;
	private String codFiscale;
	private String cartaId;
	
	public Elettore(String nome, String cognome, String codFiscale, String cartaId) {
		this.setNome(nome);
		this.setCognome(cognome);
		this.setCodFiscale(codFiscale);
		this.setCartaId(cartaId);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodFiscale() {
		return codFiscale;
	}

	public void setCodFiscale(String codFiscale) {
		this.codFiscale = codFiscale;
	}

	public String getCartaId() {
		return cartaId;
	}

	public void setCartaId(String cartaId) {
		this.cartaId = cartaId;
	}

}
