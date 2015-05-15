package Initialisation;

//Packages à importer afin d'utiliser l'objet File
import java.io.*;



public class MasterTable {
		public static Piece masterTable[][] = new Piece[4][4];
		public static Piece restaureTable[][] = new Piece[4][4];
		public static Motif tabMotifRestaure[]= new Motif[4];
		public final static int nbColonne = 4;
		public final static int nbLigne = 4;
		public int nbCase = nbColonne * nbLigne;
		//public Motif motiftab[] = new Motif[4];
		

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
		 


	
	
	//Initialise le tableau. Chaque case est remplie par une piece qui est composé grâce à initPiece
		public MasterTable (){
			
			

			masterTable[0][0] = new Piece(Motif.MOTIF_0, Motif.MOTIF_0, Motif.MOTIF_2, Motif.MOTIF_1);
			//Piece 0 1
			masterTable[0][1] = new Piece(Motif.MOTIF_0, Motif.MOTIF_1, Motif.MOTIF_3, Motif.MOTIF_1);
			//Piece 0 2
			masterTable[0][2] = new Piece(Motif.MOTIF_0, Motif.MOTIF_1, Motif.MOTIF_4, Motif.MOTIF_1);
			//Piece 0 3
			masterTable[0][3] = new Piece(Motif.MOTIF_0, Motif.MOTIF_1, Motif.MOTIF_2, Motif.MOTIF_0);

					
			
			//Piece 1 0
			masterTable[1][0] = new Piece(Motif.MOTIF_2, Motif.MOTIF_0, Motif.MOTIF_1, Motif.MOTIF_3);
			//Piece 1 1
			masterTable[1][1] = new Piece(Motif.MOTIF_3, Motif.MOTIF_3, Motif.MOTIF_4, Motif.MOTIF_3);
			//Piece 1 2
			masterTable[1][2] = new Piece(Motif.MOTIF_4, Motif.MOTIF_3, Motif.MOTIF_3, Motif.MOTIF_4);
			//Piece 1 3
			masterTable[1][3] = new Piece(Motif.MOTIF_2, Motif.MOTIF_4, Motif.MOTIF_2, Motif.MOTIF_0);

			
			//Piece 2 0
			masterTable[2][0] = new Piece(Motif.MOTIF_1, Motif.MOTIF_0, Motif.MOTIF_2, Motif.MOTIF_3);
			//Piece 2 1
			masterTable[2][1] = new Piece(Motif.MOTIF_4, Motif.MOTIF_3, Motif.MOTIF_3, Motif.MOTIF_4);
			//Piece 2 2
			masterTable[2][2] = new Piece(Motif.MOTIF_3, Motif.MOTIF_4, Motif.MOTIF_4, Motif.MOTIF_4);
			//Piece 2 3
			masterTable[2][3] = new Piece(Motif.MOTIF_2, Motif.MOTIF_4, Motif.MOTIF_1, Motif.MOTIF_0);


			
			//Piece 3 0
			masterTable[3][0] = new Piece(Motif.MOTIF_2, Motif.MOTIF_0, Motif.MOTIF_0, Motif.MOTIF_2);
			//Piece 3 1
			masterTable[3][1] = new Piece(Motif.MOTIF_3, Motif.MOTIF_2, Motif.MOTIF_0, Motif.MOTIF_2);
			//Piece 3 2
			masterTable[3][2] = new Piece(Motif.MOTIF_4, Motif.MOTIF_2, Motif.MOTIF_0, Motif.MOTIF_1);
			//Piece 3 3
			masterTable[3][3] = new Piece(Motif.MOTIF_1, Motif.MOTIF_1, Motif.MOTIF_0, Motif.MOTIF_0);

			
			
		}
		/* renvoie le symbole du motif de la piece i j contenu dans le tableau*/
		public int getSymboleNum(int i,int j, int num){
			return masterTable[i][j].motif[num].getSymbole();
		}
		/* renvoie le symbole du motif de la piece i j contenu dans le tableau*/
		public File getFichierNum(int i, int j, int num){
			return masterTable[i][j].motif[num].getFichier();
		}
		
		public String getSymbolePiece(int i,int j){
			
				return (masterTable[i][j].motif[0].getSymbole() + " " + masterTable[i][j].motif[1].getSymbole() + " " + masterTable[i][j].motif[2].getSymbole() + " " + masterTable[i][j].motif[3].getSymbole());
			
		}
		
		
		
			
			
		
		public static void fctSauvegarder(){
			DataOutputStream dos;
			try {
			      dos = new DataOutputStream(
			              new BufferedOutputStream(
			                new FileOutputStream(
			                  new File("PORSCHE.txt"))));
			      	
			      for(int i=0 ; i < nbLigne ; i++){
			    	for(int j=0; j < nbColonne ; j++)  {
				      for(int k = 0 ; k < 4 ; k++){
				    	  
				    	  dos.writeInt(masterTable[i][j].motif[k].getSymbole());
							
				      }
			    	}
			      }
			      
			      /*
			       
			       for(int i=0;i<tab.length()>i;i++)
						for(int j=0;i<tab[i].length()>j;j++)
							masterTable[i][j]=null; 
			       
			        */
			      dos.close();
			      
			      
			  } catch (FileNotFoundException e) {
			      e.printStackTrace();
			    } catch (IOException e) {
			      e.printStackTrace();
			    }	
			
		}
		
		
		public static void fctRestaurer(){
			DataInputStream dis;
			int a;
			try {
			      
			    
			      dis = new DataInputStream(
			              new BufferedInputStream(
			                new FileInputStream(
			                  new File("PORSCHE.txt"))));
			      for(int i = 0; i < nbLigne; i++){
			    	  for(int j = 0; j< nbColonne ; j++){
			    		  for(int k = 0 ; k < 4 ; k++){
			    			 
			    			  a =dis.readInt();
			    			//  System.out.println(a);
			    			  	switch(a){
				    			  	case 0:
				    			  		tabMotifRestaure[k] = Motif.MOTIF_0;
				    			  		break;
				    			  	case 1:
				    			  		tabMotifRestaure[k] = Motif.MOTIF_1;
				    			  		break;
				    			  	case 2:
				    			  		tabMotifRestaure[k] = Motif.MOTIF_2;
				    			  		break;
				    			  	case 3:
				    			  		tabMotifRestaure[k] = Motif.MOTIF_3;
				    			  		break;
				    			  	case 4:
				    			  		tabMotifRestaure[k] = Motif.MOTIF_4;
				    			  		break;
				    			  	case 5:
				    			  		tabMotifRestaure[k] = Motif.MOTIF_5;
				    			  		break;
				    			  	default:
				    			  	    System.out.println("Il faut davantage travailler.");
			    			  	}
						      } 
			    		  
			    		  restaureTable[i][j] = new Piece(tabMotifRestaure[0], tabMotifRestaure[1], tabMotifRestaure[2],tabMotifRestaure[3]);
			    	  }
			      }
			      
			      
			  } catch (FileNotFoundException e) {
			      e.printStackTrace();
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
		
		}
			
	/* La Fonction a pour but de mélanger le tableau  en échangeant la position des pieces entre elle et en les rotant */
		public void fctMelangeur(){
			int i,j,k,l; 
			Piece swap;
			
			/* Mélange les pièces entre eux */
			for(int m=0;m<=16;m++){
				i =(int)(Math.random() * 3);//a verifier qu'on obtient aussi 0 sinon il va seulement de 1 à 3
				j = (int)(Math.random ()* 3);
				k =  (int)(Math.random ()* 3);
				l= (int)(Math.random ()* 3);
				swap = masterTable[i][j];
				masterTable[i][j] = masterTable[k][l];
				masterTable[k][l] = swap;
			}
			
		/* Fait roter toutes les pièces aux hasard*/
			
			//Double bouble pour choisir chaque piece du tableau2D
			for(i = 0 ; i<4; i++){
				for(j = 0 ; j<4; j++){
					/*fait tourner la pièce un nombre x fois*/
					for(int m = (int)(Math.random() * 3) ; m >=0 ; m--)
						masterTable[i][j].fctPieceRetourner();
				}
			}
			
		}
		
		public boolean fctVerif(){
			boolean verif = true;
			
			for(int i = 0 ; i < nbLigne ; i++){
				for(int j = 0 ; j< nbColonne ; j++){
					System.out.println("boucle i" + " " + i);
					System.out.println("    boucle j" + " " + j);
					if(i == 0 && masterTable[i][j].getSymboleNum(0)!=0){
						System.out.println("Fail 1");
						verif = false;
						break;
					}
					if(j == 0 && masterTable[i][j].getSymboleNum(1)!=0 ){
						System.out.println("Fail 2");
						verif = false;
						break;
					}
					if(i == nbColonne-1 && masterTable[i][j].getSymboleNum(2)!=0){
						System.out.println("Fail 3 ");
						verif = false;
						break;
					}
					if(j == nbLigne-1 && masterTable[i][j].getSymboleNum(3)!=0 ){
						System.out.println("Fail 4 ");
						verif = false;
						break;
					}
					
					if( i !=nbLigne-1 && masterTable[i][j].getSymboleNum(2) != masterTable[i+1][j].getSymboleNum(0)){
						System.out.println("Fail 5");
						verif = false;
						break;
					}
					if( j !=nbColonne-1 && masterTable[i][j].getSymboleNum(3) != masterTable[i][j+1].getSymboleNum(1)){
						System.out.println("Fail 6");
						verif = false;
						break;
					}
					
				}
				if( verif == false)
					break;
			}
			
			return verif;
		}
	}
	
	


