package Initialisation;



public class MasterTable {
		public Piece masterTable[][] = new Piece[4][4];
		public Motif tabMotif[]=new Motif[5];
		public int nbColonne = 4;
		public int nbLigne = 4;
	 
	
		 public int fctRandom(){
			 int random = (int)(Math.random() * (5-0));
			 return random;
		 }
	 
	 
		 public Piece initPiece(int i, int j){
			
			Motif motif_0 = null;
			Motif motif_1=null;
			Motif motif_2=null;
			Motif motif_3=null;
			
			
			if(i == 0)
				motif_0 = Motif.MOTIF_0;
			if(j == 0)
				motif_1 = Motif.MOTIF_0;
			if(i == nbColonne-1)
				motif_0 = Motif.MOTIF_0;
			if(j == nbLigne-1)
				motif_1 = Motif.MOTIF_0;
			
			
			
			
			Piece piece = new Piece(motif_0,motif_1,motif_2,motif_3);
			
			/*if (piece == null){
				System.out.println("Erreur la piece est vide ");
				System.exit(-1);
			}*/
			
			
				//Pk ça me fait dead code ?
				
				return piece;
				
		 }
		 
		//Fonction qui retourne les pièce dans le sens inverse d'une horloge
			public Piece fctPieceRetourner( Piece piece ){
				Motif swap;
				
				swap = piece.motif[0];
				piece.motif[0] = piece.motif[1];
				piece.motif[1] = piece.motif[2];
				piece.motif[2] = piece.motif[3];
				piece.motif[3] = swap;
				
				
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
				for(int j = 0 ; j<4 ; j++)
					masterTable [i][j] = initPiece(i,j);
			}
		}
	
		
		
			
	/* La Fonction a pour but de mélanger le tableau  en échangeant la position des pieces entre elle et en les rotant */
		public void fctMelangeur(){
			int i,j; 
			Piece swap;
			
			/* Mélange les pièces entre eux */
			for(int k=0;k<=16;k++){
				i =(int)(Math.random() * 3);//a verifier qu'on obtient aussi 0 sinon il va seulement de 1 à 3
				j = (int)(Math.random ()* 3);
					
				swap = masterTable[i][j];
				masterTable[i][j] = masterTable[j][i];
				masterTable[j][i] = swap;
			}
			
		/* Fait roter toutes les pièces aux hasard*/
			
			//Double bouble pour choisir chaque piece du tableau2D
			for(i = 0 ; i<4; i++){
				for(j = 0 ; j<4; j++){
					/*fait tourner la pièce un nombre x fois*/
					for(int l = 0 ; l < (i =(int)(Math.random() * 3)) ; l++)
						fctPieceRetourner( masterTable[i][j] );
				}
			}
			
		}
	}
	
	


