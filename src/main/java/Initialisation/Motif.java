package Initialisation;

import java.io.File;


public enum Motif {
	MOTIF_0(0, null),MOTIF_1(1, null),MOTIF_2(2, null),MOTIF_3(3, null),MOTIF_4(4, null),MOTIF_5(5,null);
	private int symbole;
	private File f;
	
	Motif(int symbole, File f){
		this.symbole= symbole;
		this.f=f;
	}
	
	public int getSymbole(){
		return this.symbole;
	}
	
	public File getFichier(){
		return this.f;
	}
}

