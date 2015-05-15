package Jeu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.Point;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;


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
					pieces[i][j].rotationDroite();
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
								
		//On melange tout sa a la sauce random
		Melanger();
		
		//On fait des rotations a la sauce random	
		  Retourner();
			
		update();
	
	}
	
	private int eden(int min,int max){			
			return (int)(Math.random() * (max-min)) + min;		
			}
	
		
	private void Melanger(){
		for(int i=0; i<size.x ; i++){
			for(int j=0; j<size.y ; j++){					
				pieces[i][j].Echange(pieces[eden(0,4)][eden(0,4)]);					
			}
		}
	}
		
	
	
	
	public boolean verification(){	
		
		//On verifie la similitude des cases adjacentes
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
		
	System.out.println("Vous avez gagné! =D") ;
		return true;
		
	}	
	
	public void fctSauvegarder(){
		
		
		System.out.println("ahahahah ça ne marche pas");
		DataOutputStream dos;
		try {
		      dos = new DataOutputStream(
		              new BufferedOutputStream(
		                new FileOutputStream(
		                  new File("save.txt"))));
		      	
		      for(int i=0 ; i < 4 ; i++){
		    	for(int j=0; j < 4 ; j++)  {
			      for(int k = 0 ; k < 4 ; k++){
			    	  dos.writeInt(pieces[i][j].getFace(k));
			      }
			      dos.writeDouble(pieces[i][j].getPiecePointX());
			      
			      dos.writeDouble(pieces[i][j].getPiecePointY());
		    	}
		      }
		      
		      
		      dos.close();
		      
		      
		  } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }	
		
	}

}

