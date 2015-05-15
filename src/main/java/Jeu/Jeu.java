package Jeu;

import Initialisation.MasterTable;
import Initialisation.Piece;

public class Jeu {
	public static final int  nbColonne = 4;
	public static final int nbLigne = 4;
	public Piece restaureTable[][] = new Piece[4][4];
	
	
	public boolean fctVerif(){
		boolean verif = true;
		
		return verif;
	}
	
	
	public static void main(String[] args) {
		
		
		
		
		MasterTable initable = new MasterTable();
		initable.fctSauvegarder();
		initable.fctRestaurer();
	}
	
}


