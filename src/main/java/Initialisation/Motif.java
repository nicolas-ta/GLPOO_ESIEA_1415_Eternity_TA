package Initialisation;

import java.io.File;


public enum Motif {
	MOTIF_0("NOIR", null),MOTIF_1("BLANC", null),MOTIF_2("JAUNE", null),MOTIF_3("ORANGE", null),MOTIF_4("BLEU", null),MOTIF_5("ROUGE",null);
	private String symbole;
	private File f;
	
	Motif(String symbole, File f){
		this.symbole= symbole;
		this.f=f;
	}
	
	public String getSymbole(){
		return this.symbole;
	}
	
	public File getFichier(){
		return this.f;
	}
}
