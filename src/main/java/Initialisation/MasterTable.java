package Initialisation;



public class MasterTable {
	public Piece masterTable[][] = new Piece[4][4];
	public Motif tabMotif[]=new Motif[5];
	
	
	 
	
	 public int fctRandom(){
		 int random = (int)(Math.random() * (5-0));
		 return random;
	 }
	 
	 
	 public Piece initPiece(){
		
		Piece piece = null;
		
		
		if (piece == null){
			System.out.println("Erreur la piece est vide ");
			System.exit(-1);
		}
			return piece;
			
	}
	
	
	//Initialise le tableau. Chaque case est remplie par une piece qui est composé grâce à initPiece
	MasterTable (){
		
		tabMotif[0]= Motif.MOTIF_0;
		tabMotif[1]= Motif.MOTIF_1;
		tabMotif[2]= Motif.MOTIF_2;
		tabMotif[3]= Motif.MOTIF_3;
		tabMotif[4]= Motif.MOTIF_4;
		
		 
		
		for(int i = 0 ; i<4 ; i++){
			for(int j = 0 ; j<4 ; j++){
				masterTable [i][j] = initPiece();
			}
		}
	}
	
	//Elle mélange le tableau 
	public void fctMelangeur(){
		int i,j; 
		int swap;
		for(int k=0;k=<16;k++){
		i =(int)(Math.random() * 3);
		j = (int)(Math.random ()* 3);
			
		swap=masterTable[i][j];
		masterTable[i][j]= masterTable[j][i];
		masterTable[j][i]= swap;
		}
		}
	}
	
	


