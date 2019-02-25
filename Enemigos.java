import java.awt.*;

public class Enemigos extends Thread {
  //wraps (contains) the matrix of "martians"
  //and methods to move and "manage" them 

  Enemigo [][] martians ;
  int direction = 1; 
  int rows, columns;
  double wait = 150;
  Puntos p;
  Graphics g;
  
  Enemigos(Graphics g, Puntos p, int x, int y, int columns, int rows) {
      this.columns = columns;
      this.rows = rows;
      this.p = p;
      this.g = g;
      martians = new Enemigo[columns][rows];
      for (int i = 0; i < columns; i++)
        for (int j = 0; j < rows; j++) {
           martians [i][j] = new Enemigo(g, x+(i*30), y+(j*20)); 
           martians[i][j].dibujar();
        }
  }

  public boolean tocado(int x, int y) {
     for (int i = 0; i < columns; i++)
        for (int j = 0; j < rows; j++) {
           if (martians[i][j] != null) 
              if (martians [i][j].getPosx() <= x &&
                  martians [i][j].getPosx()+20 >= x &&  
                  martians [i][j].getPosy() <= y &&
                  martians [i][j].getPosy()+10 >= y  ) {
                  martians[i][j].borrar(); //delete
                  martians[i][j] = null;
                  p.Bingo(1);
                  return true;
              }
        }
      return false;
  }
                  
  
  public void run() {

     while (true) {
        boolean change = false; 
        if (direction == 1) {
          for(int i = columns-1; i >=0; i--) 
             for (int j = 0; j < rows; j ++) 
                 if (martians[i][j] != null) {
                     martians[i][j].borrar();
                     martians[i][j].addx(1);
                     martians[i][j].dibujar();
                     if (martians[i][j].getPosx() >= 480) {
                    	 change = true;
                    	 
                     }
                  }
         } else {

         for(int i = 0; i < columns; i++) 
             for (int j = 0; j < rows; j ++) 
                 if (martians[i][j] != null) {
                     martians[i][j].borrar();
                     martians[i][j].addx(-1);
                     martians[i][j].dibujar();
                     if (martians[i][j].getPosx() <= 0) change = true;
                  }
         } 
          if (change) {
        	wait = wait/1.25;
            for(int i = columns-1; i >=0; i--) 
             for (int j = 0; j < rows; j ++) 
                 if (martians[i][j] != null) {
                	 martians[i][j].borrar();
                     martians[i][j].addy(5);
                     martians[i][j].dibujar();
                 }
            direction = -direction;
          }
          
          for(int i = 0; i < columns; i++) {
        	  for(int j = 0; j < rows; j++) {
        		  if(martians[i][j] != null) {
        			  if(martians[i][j].getPosy() >=280) {
        				 g.drawString("GAME OVER", 250, 20);
        				 return;
        			  }
        		  }
        	  }
          }
          
          try {sleep((long) wait);} catch (Exception e) {}
     }
   }                    
      
}
       