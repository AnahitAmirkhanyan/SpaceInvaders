import java.awt.*;
import java.awt.event.*;

class Game extends Frame implements KeyListener {
   Canvas c;
   Nave ship;Bala bullet;
   Enemigos z1;
   Puntos points;
   Spaceship ufo;
   
   public Game()  {
      super("Space AUA Invaders");
      //a canvas to paint the game
      c = new Canvas(); c.setSize(500,300);
      c.setBackground(new Color(0,0,0));
      this.add(c);

      //game basically controlled by keys
      c.addKeyListener(this);
      this.pack(); this.setVisible(true);
      Puntos points=new Puntos(c.getGraphics());
      points.start();
      
      z1=new Enemigos(c.getGraphics(),points,5,5,15,5);
      z1.start(); //start moving enemies
      ship = new Nave(c.getGraphics());
      ship.start(); //start moving ship (on the ground)
	  ufo = new Spaceship(c.getGraphics(), points, 0, 40, z1);
	  ufo.start();
      c.requestFocus();

   }
	
   public void keyPressed(KeyEvent K){
	  if(!z1.isAlive()) return;
      if (K.getKeyCode()==39) 
        ship.moverDer();  //move right
      if (K.getKeyCode()==37) 
        ship.moverIzq();  //move left
      if (K.getKeyCode()==38) { 
        //release a new bullet is no one was (still) there
        if (bullet == null || !bullet.isAlive()) {
        bullet = new Bala(c.getGraphics(), ship.getPos(),z1, ufo);
        bullet.start();
        }
      }
   }

   public void keyTyped(KeyEvent K){
   }

   public void keyReleased(KeyEvent K){
      if ((K.getKeyCode()==39) || (K.getKeyCode()==37))
         ship.detener(); //stop ship 
   }


   public static void main(String args[]){
      Game J=new Game();
      J.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);}
	});
   }

}
