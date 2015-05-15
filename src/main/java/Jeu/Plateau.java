package Jeu;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Plateau {
	
	public Point size;
	public int s;
	public Piece pieces[][];
			
	public void init(){		
		for(int i=0; i<size.x ; i++){
			for(int j=0; j<size.y ; j++){				
				pieces[i][j].Face(0,0,0,0);		 
			}
		}	
		update();
	}


	private void Retourner(){
		for(int i=0; i<size.x ; i++){
			for(int j=0; j<size.y ; j++){					
				for(int r=0; r<(int)(Math.random() * (4))  ; r++){	
					pieces[i][j].rotationGauche();
				}									
			}
		}		
	}	
	
	
	public Plateau(int x, int y,int s){
				
	//	System.out.println("Creation du plateau size :" + x + ";" + y);
		size = new Point(x,y);
		pieces = new Piece[x][y];
		this.s = s;
		
		for(int i=0; i<x ; i++){
			for(int j=0; j<y ; j++){				
				pieces[i][j] = new Piece(s);		 
			}
		}			
		
	}
	
	public void update(){
		for(int i=0; i<size.x ; i++){
			for(int j=0; j<size.y ; j++){				
				pieces[i][j].update();	 
			}
		}
	}	
	public void Lecture() {	
	

		//Piece coder en dur en attendant la lecture du csv (Lecture();)
		// noir = 1
		// cyan = 2
		// jaune = 3
		// orange = 4
		// pink = 5
		pieces[0][0].Face(1,1,2,4);
		pieces[1][0].Face(2,1,4,5);
		pieces[2][0].Face(4,1,4,2);
		pieces[3][0].Face(4,1,1,3);
		
		pieces[0][1].Face(1,4,2,5);
		pieces[1][1].Face(2,5,3,4);
		pieces[2][1].Face(3,2,4,2);
		pieces[3][1].Face(4,3,1,2);
		
		pieces[0][2].Face(1,5,2,4);
		pieces[1][2].Face(2,4,5,4);
		pieces[2][2].Face(5,2,3,2);
		pieces[3][2].Face(3,2,1,2);
		
		pieces[0][3].Face(1,4,5,1);
		pieces[1][3].Face(5,4,3,1);
		pieces[2][3].Face(3,2,5,1);
		pieces[3][3].Face(5,2,1,1);
								
		//On melange tout sa a la sauce randome
		Melanger();
		
		//On fait des rotations a la sauce randome			
		Retourner();
		
		
		/*LECTURE DU CSV*/
		
		File face = new File("faces.csv");	
		File piece = new File("pieces.csv");
		Scanner scanner;	
		try {	
			
			scanner = new Scanner (face);		
			System.out.println(scanner.nextLine());		
			Face test[] = new Face[5];	
			for(int i=0; i<5 ; i++){
				test[i] = new Face(scanner.next().charAt(0),Integer.parseInt(scanner.next()),scanner.next());
			}
			
			scanner = new Scanner (piece);		
			System.out.println(scanner.nextLine());		
			for(int i=0; i<16 ; i++){
				/*scanner.next().charAt(0)
				Integer.parseInt(scanner.next())
				Integer.parseInt(scanner.next())
				Integer.parseInt(scanner.next())
				Integer.parseInt(scanner.next())
				Integer.parseInt(scanner.next())*/
			}
			   
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		update();
	
	}
	
		
	private void Melanger(){
		Piece swap;
		int k,l;
		for(int i=0; i<size.x ; i++){
			for(int j=0; j<size.y ; j++){		
				  k=(int)(Math.random() * (4));
				  l = (int)(Math.random() * (4));
			
				swap = pieces[i][j];
				pieces[i][j] = pieces[k][l];
				pieces[k][l] = swap;
				
				
			//	pieces[i][j].Echange(pieces[eden(0,4)][eden(0,4)]);					
			}
		}
	}
		
	
	
	
	public boolean verification(){	
		
		//On verifie que les faces voisine sont les meme
				for(int i=1; i<size.x-1 ; i++){
					for(int j=1; j<size.y-1 ; j++){	
						if(pieces[i][j].faces[0] == 0)
							return false;
						else{
							//On vérifie les bord
							if(i == 0 && pieces[i][j].faces[0] != 1)
								return false;
							if(j == 0 && pieces[i][j].faces[1] != 1)
								return false;
							if(i == 3 && pieces[i][j].faces[2] != 1)
								return false;
							if(j == 3 && pieces[i][j].faces[3] != 1)
								return false;
							
							
							//Inutile de vérifier Face 0 et 1 car répétition
							
							if(pieces[i][j].faces[2] != pieces[i+1][j].faces[0]){	
								return false;
							}	
							
							if(pieces[i][j].faces[3] != pieces[i][j+1].faces[1]){	
								return false;
							}
						}
						
						
					}
				}
		
		//C'est gagner :)
		//javax.swing.JOptionPane.showMessageDialog(null,"Bravo, Tu as reussi ce jeu trop styl�eeee !!!"); 
		return true;
		
	}	

}

