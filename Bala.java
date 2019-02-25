import java.awt.*;

class Bala extends Thread{
   int xpos, ypos;
   Graphics g;
   boolean t=true;
   boolean aa,bb,cc;
   Enemigos a;

   public Bala(Graphics g, int xpos,Enemigos a){
      this.g = g;
      ypos=280;
      this.xpos=xpos;
      this.a=a;
   }

   Color black= new Color(0,0,0);

   public void run(){
      Color red = new Color(255,0,0);

      while (ypos >0){
         g.setColor(black);
         g.drawLine(xpos,ypos,xpos,ypos+5);
         ypos --;
         if (a.tocado(xpos,ypos)) {
        	 g.fillOval(xpos,ypos,3,3);
        	 return;
        	 
         }
         g.setColor(red);
         g.drawLine(xpos,ypos, xpos,ypos+5);
         try {
            Thread.sleep(7);
         } catch (InterruptedException E) {}
      }
      g.setColor(black);
      g.drawLine(xpos,0, xpos,5);

   }
   void borrar(){
   	  g.setColor(black);
      g.drawLine(xpos,ypos-1, xpos,ypos+6);
    }
   	


}
