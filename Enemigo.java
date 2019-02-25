import java.awt.*;

class Enemigo {
   int	posx;
   int	posy;
   Graphics g;
   Color black= new Color(0,0,0);
   Color green= new Color(20,255,20);

   public Enemigo(Graphics g,int posx,int posy){
	  this.g = g;
	  this.posx=posx;
	  this.posy=posy;
   }

   public void  borrar() { //borrar==delete
       g.setColor(black);
       g.drawLine(posx,posy,posx+10,posy+10);
       g.drawLine(posx+10,posy+10,posx+20,posy);
       //System.out.println("deleting "+posx+" "+posy+" "+(posx+20)+" "+(posy+10));
   }
	
   public void dibujar() { //dibujar==draw
       g.setColor(green);
       g.drawLine(posx,posy,posx+10,posy+10);
       g.drawLine(posx+10,posy+10,posx+20,posy);
        //System.out.println("drawing "+posx+" "+posy+" "+(posx+20)+" "+(posy+10));
		 
   }
      
   public void	addx(int x){	
	  posx +=x;
   }

   
   public void	addy(int x){	
	  posy +=x;
   }
     
   public int getPosx(){
     	return posx;
   }
     
   public int getPosy(){
     	return posy;
   }


}
