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
		
		this.setCodFiscale(codFiscale); // possiamo fare inserire il codFisc come string e poi usare .toCharArray() per trasformarlo in char[]
	}

	public char[] getCodFiscale() {
		return codFiscale;
	}

	// ha senso new char[16]? cioè serve a qualcosa? ho risposto sopra 
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

	
	public boolean checkAnno(char[] cod) {
		int anno=this.getAnnoNascita();
		if(cod[7]==(anno%10)) {
			anno=anno%10;
			if(cod[6]==(anno%10)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkMese(char[] cod) {
		/*Qua in realtà volevo usare i caratteri ascii per calcolare le lettere
		 * fare cod[8]==mese+96 che sarebbe il codice ascii della lettera corrispondente, ma non so come funziona il casting con gli ascii
		 * perchè cod ti rida un char mentre mese+96 sarebbe un int, se riusciamo a trasformarlo tramite ascii in lettera è gucci, almeno
		 * tolgo sto switch brutto.
		 */
		int mese=this.getMeseNascita();
		switch(mese) {
		case 1:
			if(cod[8]=='a')
				return true;
			break;
		case 2:
			if(cod[8]=='b')
				return true;
			break;
		case 3:
			if(cod[8]=='c')
				return true;
			break;
		case 4:
			if(cod[8]=='d')
				return true;
			break;
		case 5:
			if(cod[8]=='e')
				return true;
			break;
		case 6:
			if(cod[8]=='f')
				return true;
			break;
		case 7:
			if(cod[8]=='g')
				return true;
			break;
		case 8:
			if(cod[8]=='h')
				return true;
			break;
		case 9:
			if(cod[8]=='i')
				return true;
			break;
		case 10:
			if(cod[8]=='l')
				return true;
			break;
		case 11:
			if(cod[8]=='m')
				return true;
			break;
		case 12:
			if(cod[8]=='n')
				return true;
			break;
		default:
			return false;
		}
		return false;
	}
	
	public boolean checkGiorno(char[] cod) {
		int giorno=this.getGiornoNascita();
		String sesso=this.getSesso();
		if(sesso=="Uomo") {
			if(giorno<10) {
				if((cod[9]=='0')&&(cod[10]==(char)giorno)) {
					return true;
				}
			}else{
				if(cod[10]==(char)giorno%10){
					giorno=giorno%10;
					if(cod[9]==(char)giorno%10)
						return true;
				}
			}
			return false;
		}else{ //se è donna
			if(giorno<10) {
				if((cod[9]=='4')&&(cod[10]==(char)giorno)) {
					return true;
				}
			}else{
				if(cod[10]==(char)giorno%10){
					giorno=(giorno%10)+4;
					if(cod[9]==(char)giorno%10)
						return true;
				}
			}
			return false;
		}
	}
	
	//il metodo checkCodFiscale potrebbe usare altri metodi per aumentare l'astrazione ? direi di si
	public boolean checkCodFiscale(char[] cod) {
		//ciclo per controllare cognome -> 3 lettere

		//ciclo per controllare nome -> 3 lettere
		
		//ciclo per controllare anno di nascita -> 2 numeri
		if (!checkAnno(cod)) //se è false mi fermo
			return false;
		//ciclo per controllare lettera del mese -> 1 lettera
		if (!checkMese(cod)) //se è false mi fermo
			return false;
		//ciclo per controllare giorno di nascita -> 2 numeri
		if(!checkGiorno(cod)) //se è false mi fermo
			return false;
		//se tutte le verifiche sono corrette ritorno 'true', altrimenti esco prima con false
		return true;
	}


}
