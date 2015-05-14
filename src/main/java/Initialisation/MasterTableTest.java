package Initialisation;


public class MasterTableTest {

	public static final int  nbColonne = 4;
	public static final int nbLigne = 4;
	public Piece restaureTable[][] = new Piece[4][4];
	
	
	
	public static void main(String[] args) {
		
		//Test de l'énumération Motif
	/*	Motif testMotif_0 = Motif.MOTIF_0;
		Motif testMotif_1 = Motif.MOTIF_1;
		Motif testMotif_2 = Motif.MOTIF_2;
		Motif testMotif_3 = Motif.MOTIF_3;
		*/
		//test de la Class Piece
	/*	Piece testPiece = new Piece(testMotif_0, testMotif_1, testMotif_2, testMotif_3);
		System.out.println();
		System.out.println(testPiece.getSymboleNum(0));
		System.out.println(testPiece.getSymboleNum(1));
		System.out.println(testPiece.getSymboleNum(2));
		System.out.println(testPiece.getSymboleNum(3));*/
		
		//testPiece.fctSauvegardeEncapsule();
		
		
		//testPiece.fctPieceRetourner();
		/*
		System.out.println("\n la piece est retournée");
		System.out.println(testPiece.getSymboleNum(0));
		System.out.println(testPiece.getSymboleNum(1));
		System.out.println(testPiece.getSymboleNum(2));
		System.out.println(testPiece.getSymboleNum(3));
		*/
		
		
		
		
		
		MasterTable initable= new MasterTable();
		if(initable.fctVerif() == false){
			System.out.println("raté");
		}
		else{
			System.out.println("réussi");
		}
		//System.out.println("Tableau initialisé : "+ initable.getSymbolePiece(1,0));//mal codé, je voudrai faire initable.mastertable[0][0].getSymbolePiece(0,0) Comment fait on ?
		//initable.fctMelangeur();
		/*System.out.println("Tableau mélangé : " + initable.getSymbolePiece(1,0));//mal codé, je voudrai faire initable.mastertable[0][0].getSymbolePiece(0,0) Comment fait on ?
		System.out.println(initable.getSymbolePiece(2,2));//mal codé, je voudrai faire initable.mastertable[0][0].getSymbolePiece(0,0) Comment fait on ?
		
		*/
	//	initable.masterTable[0][0];
		initable.fctSauvegarder();
		
		initable.fctRestaurer();
		
	}
}
