package progetto;

public class Elettore extends Persona{
	
	private char[] codFiscale;
	private boolean voto;
	
	//non so come gestire l'array di char di codice fiscale
	public Elettore(String nome, String cognome, int giornoNascita, int meseNascita, int annoNascita, String comuneNascita, String nazioneNascita, String sesso, char[] codFiscale, boolean voto) {
		this.setNome(nome);
		this.setCognome(cognome);
		this.setGiornoNascita(giornoNascita);
		this.setMeseNascita(meseNascita);
		this.setAnnoNascita(annoNascita);
		this.setComuneNascita(comuneNascita);
		this.setNazioneNascita(nazioneNascita);
		this.setSesso(sesso);
		this.setVoto(voto);
		
		this.setCodFiscale(codFiscale);
	}

	public char[] getCodFiscale() {
		return codFiscale;
	}

	// ha senso new char[16]? cioè serve a qualcosa? 
	public void setCodFiscale(char[] codFiscale) {
		codFiscale = new char[16];
		this.codFiscale = codFiscale;
	}
	
	public boolean isVoto() {
		return voto;
	}

	public void setVoto(boolean voto) {
		this.voto = voto;
	}
	
	public void esprimi_voto() {}

	//il metodo checkCodFiscale potrebbe usare altri metodi per aumentare l'astrazione ?
	public boolean checkCodFiscale(char[] cod) {
		//ciclo per controllare cognome -> 3 lettere

		//ciclo per controllare nome -> 3 lettere
		
		//ciclo per controllare anno di nascita -> 2 numeri
		
		//ciclo per controllare lettera del mese -> 1 lettera
		
		//ciclo per controllare giorno di nascita -> 2 numeri
		
		//se tutte le verifiche sono corrette ritorno 'true', altrimenti esco prima con false
		return true;
	}

}
