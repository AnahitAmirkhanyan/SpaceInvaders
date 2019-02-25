import java.awt.*;

class Nave extends Thread {
int pos, opos, dir; //position, old-position, direction
Graphics g;
Color black = new Color(0,0,0);
Color col = new Color(255,255,255);
int posy;

   public Nave(Graphics g){
      this.g = g;
      pos=150;
      dir =0;
      g.setColor(col);
      g.drawLine(pos,290,pos-5,299);
      g.drawLine(pos,290,pos+5,299);
   }

   public void run(){

      while (true){
         opos = pos;
         pos += dir; //we always update position by dir
                     //but sometimes dir == 0
         if ((pos<5) || (pos>495)) 
            pos=opos; //dont move outside bounds

         if (opos != pos){ //if there was an update
            g.setColor(black);
            g.drawLine(opos,290,opos-5,299);
            g.drawLine(opos,290,opos+5,299);
    
            g.setColor(col);
            g.drawLine(pos,290,pos-5,299);
            g.drawLine(pos,290,pos+5,299);
         }
         try {
            Thread.sleep(7);
         } catch(InterruptedException E){
         }
      }
   }

   public void moverDer(){ //move right
      dir = 1;
   }
 
   public void moverIzq(){ //move left
      dir = -1;
   }

   public void detener(){  //stop
      dir = 0;
   }

   public int getPos(){
      return(pos);
   }

}