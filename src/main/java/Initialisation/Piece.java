package Initialisation;


import java.io.File;


public class Piece {
	
	public Motif motif[] = new Motif[4];
	
	//Initialise l'objet piece avec les motif rentrï¿½ en paramï¿½tre. C'est dans la Class MasterTable qu'on choisi quel motif mettre ï¿½ quel endroit
	Piece (Motif motif_0, Motif motif_1, Motif motif_2, Motif motif_3) {
		motif[0] = motif_0;
		motif[1] = motif_1;
		motif[2] = motif_2;
		motif[3] = motif_3;
	}
	/*
	 Il faudra peut ï¿½tre faire une fonction d'ï¿½change de motif entre 2 motifs d'un mï¿½me tableau 
	 */
	
	
	
	public String getSymboleNum(int num){
		return this.motif[num].getSymbole();
	}
	public File getFichierNum(int num){
		return this.motif[num].getFichier();
	}
	
}
