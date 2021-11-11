package progetto;

public class Elettore {
	
	private String nome;
	private String cognome;
	private int giornoNascita;
	private int meseNascita;
	private int annoNascita;
	private String luogoNascita;
	private String sesso;
	private char[] codFiscale;
	private boolean voto;
	
	//non so come gestire l'array di char di codice fiscale
	
	public Elettore(String nome, String cognome, int giornoNascita, int meseNascita, int annoNascita, String luogoNascita, String sesso, char[] codFiscale, boolean voto) {
		this.setNome(nome);
		this.setCognome(cognome);
		this.setGiornoNascita(giornoNascita);
		this.setMeseNascita(meseNascita);
		this.setAnnoNascita(annoNascita);
		this.setLuogoNascita(luogoNascita);
		this.setCodFiscale(codFiscale);
		this.setSesso(sesso);
		this.setVoto(voto);
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
	
	public int getGiornoNascita() {
		return giornoNascita;
	}

	public void setGiornoNascita(int giornoNascita) {
		this.giornoNascita = giornoNascita;
	}

	public int getMeseNascita() {
		return meseNascita;
	}

	public void setMeseNascita(int meseNascita) {
		this.meseNascita = meseNascita;
	}

	public int getAnnoNascita() {
		return annoNascita;
	}

	public void setAnnoNascita(int annoNascita) {
		this.annoNascita = annoNascita;
	}
	
	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public char[] getCodFiscale() {
		return codFiscale;
	}

	public void setCodFiscale(char[] codFiscale) {
		this.codFiscale = codFiscale;
	}
	
	public boolean isVoto() {
		return voto;
	}

	public void setVoto(boolean voto) {
		this.voto = voto;
	}
	
	
	
	public void esprimi_voto() {}



}
