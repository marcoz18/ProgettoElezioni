package progetto;

public class Elettore extends Persona{
	
	private char[] codFiscale;
	private boolean voto;
	
	public Elettore(String nome, String cognome, int giornoNascita, int meseNascita, int annoNascita, String comuneNascita, String nazioneNascita, String sesso, String codFiscale, boolean voto) {
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
	
	public void setCodFiscale(String codF) {
		this.codFiscale = codF.toCharArray();
	}
	
	public boolean isVoto() {
		return voto;
	}

	public void setVoto(boolean voto) {
		this.voto = voto;
	}
	
	public void esprimi_voto() {}

	public boolean checkCodFiscale() {
		char[] cod = this.codFiscale;
		//check per cognome -> 3 lettere
		if (!checkCogn(cod))
			return false;
		//check per nome -> 3 lettere
		if (!checkName(cod))
			return false;
		//check per anno di nascita -> 2 numeri
		if (!checkAnno(cod)) 
			return false;
		//check per mese di nascita -> 1 lettera
		if (!checkMese(cod)) 
			return false;
		//check per giorno di nascita -> 2 numeri
		if(!checkGiorno(cod))
			return false;
		//check per comune di nascita -> 1 lettera + 3 numeri
		if(!checkCom(cod)) 
			return false;
		//check ultimo carattere -> 1 lettera
		if(!checkLast(cod)) 
			return false;
		//se tutte le verifiche sono corrette ritorno 'true', altrimenti esco prima con false
		return true;
	}
	
	public boolean checkLast(char[] cod) {
		if((cod[15]<'A') && (cod[15]>'Z'))
			return false;
		return true;
	}
	
	public boolean checkCom(char[] cod) {
		if((cod[11]<'A') && (cod[11]>'Z'))
			return false;
		if(getNazioneNascita() != "Italia")
			if(cod[11] != 'Z')
				return false;
		for(int i = 12; i < 15; i++) {
			if((cod[i]<'0') && (cod[i]>'9'))
				return false;
		}
		return true;
	}
	
	public boolean checkAnno(char[] cod) {
		int anno = this.getAnnoNascita();
		if(cod[7] == (anno % 10)) {
			anno = anno % 10;
			if(cod[6] == (anno % 10)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkMese(char[] cod) {
		int mese = this.getMeseNascita();
		switch(mese) {
		case 1:
			if(cod[8] == 'A')
				return true;
			break;
		case 2:
			if(cod[8] == 'B')
				return true;
			break;
		case 3:
			if(cod[8] == 'C')
				return true;
			break;
		case 4:
			if(cod[8] == 'D')
				return true;
			break;
		case 5:
			if(cod[8] == 'E')
				return true;
			break;
		case 6:
			if(cod[8] == 'F')
				return true;
			break;
		case 7:
			if(cod[8] == 'G')
				return true;
			break;
		case 8:
			if(cod[8] == 'H')
				return true;
			break;
		case 9:
			if(cod[8] == 'I')
				return true;
			break;
		case 10:
			if(cod[8] == 'L')
				return true;
			break;
		case 11:
			if(cod[8] == 'M')
				return true;
			break;
		case 12:
			if(cod[8] == 'N')
				return true;
			break;
		default:
			return false;
		}
		return false;
	}
	
	public boolean checkGiorno(char[] cod) {
		int gg = this.getGiornoNascita();
		String sesso = this.getSesso();
		if(sesso == "Uomo") {
			if(gg < 10) {
				if((cod[9] == '0') && (cod[10] == (char)gg)) {
					return true;
				}
			}else{
				if(cod[10] == (char)gg % 10){
					gg = gg % 10;
					if(cod[9] == (char)gg % 10)
						return true;
				}
			}
			return false;
		}else{ //nel caso sia donna
			if(gg < 10) {
				if((cod[9] == '4') && (cod[10] == (char)gg)) {
					return true;
				}
			}else{
				if(cod[10] == (char)gg % 10){
					gg = (gg % 10) + 4;
					if(cod[9] == (char)gg % 10)
						return true;
				}
			}
			return false;
		}
	}
	
	public boolean checkCogn(char[] cod) {
		String surn = this.getCognome().toUpperCase();
		char[] surname = surn.toCharArray();
		int j = 0, k = 0;
		for(int i = 0; i < 3; i++) {
			while(j < surname.length) {
				if((surname[j] != 'A') || (surname[j] != 'E') || (surname[j] != 'I') || (surname[j] != 'O') || (surname[j] != 'U')) {
					if(cod[i] != surname[j])
						return false;
					j++;
					break;
				}
				j++;
			}
			if(j >= surname.length){
				while(k < surname.length) {
					if((surname[k] == 'A') || (surname[k] == 'E') || (surname[k] == 'I') || (surname[k] == 'O') || (surname[k] == 'U')) {
						if(cod[i] != surname[k])
							return false;
						k++;
						break;
					}
					k++;
				}
			}
			if((j >= surname.length) && (k >= surname.length)) {
				if(cod[i] != 'X')
					return false;
			}
		}
		return true;
	}
	
	public boolean checkName(char[] cod) {
		String nome = this.getNome().toUpperCase();
		char[] name = nome.toCharArray();
		int j = 0, k = 0, cons = 0;
		//conto # consonanti
		for(int x = 0; x < name.length; x++) {
			if((name[x] != 'A' ) || (name[x] != 'E') || (name[x] != 'I') || (name[x] != 'O') || (name[x] != 'U')) {
				cons++;
			}
		}
		if(cons <= 3) {
			for(int i = 3; i < 6; i++) {
				while(j < name.length) {
					if((name[j] != 'A') || (name[j] != 'E') || (name[j] != 'I') || (name[j] != 'O') || (name[j] != 'U')) {
						if(cod[i] != name[j])
							return false;
						j++;
						break;
					}
					j++;
				}
				if(j >= name.length){
					while(k < name.length) {
						if((name[k] == 'A') || (name[k] == 'E') || (name[k] == 'I') || (name[k] == 'O') || (name[k] == 'U')) {
							if(cod[i] != name[k])
								return false;
							k++;
							break;
						}
						k++;
					}
				}
				if((j >= name.length) && (k >= name.length)) {
					if(cod[i] != 'X')
						return false;
				}
			}
		}else {
			cons = 0;
			for(int i = 3; i < 6; i++) {
				while(j < name.length) {
					if((name[j] != 'A') || (name[j] != 'E') || (name[j] != 'I') || (name[j] != 'O') || (name[j] != 'U')) {
						cons++;
						if(cons != 2) {
							if(cod[i] != name[j]) 
								return false;
							j++;
							break;
						}
					}
					j++;
				}
			}
		}
		return true;
	}
}
