import java.awt.Color;
import java.awt.Graphics;

public class Spaceship extends Thread{

	   int posx;
	   int	posy;
	   Graphics g;
	   Color black= new Color(0,0,0);
	   Color green= new Color(20,255,20);
	   Puntos p;
	   boolean hit;
	   Enemigos z1;
	   
	public Spaceship(Graphics g, Puntos p, int posx,int posy, Enemigos z1) {
		this.g = g;
		this.posx = posx;
		this.posy = posy;
		this.p = p;
		hit = false;
		this.z1 = z1;
	}
	
	public void dibujar() {
		g.setColor(green);
		g.fillOval(posx, posy, 70, 30); // it's a spaceship but only an oval (sophisticated martian technology)
	}
	
	public void borrar() {
		g.setColor(black);
		g.fillOval(posx, posy, 70, 30);
	}
	
	public boolean tocado(int x, int y) {
		
		if(posx <= x && posx + 70 >= x && posy == y) {
			borrar();
			p.Bingo(30);
			hit = true;
			return true;
		}

		return false;
	}

	public void addx(int x) {
		posx += x;
	}
	
	public void run() {
		posx = 0;
		
		while(true) {
			
			if(!z1.isAlive()) return;
//			dibujar();
			borrar();
			addx(5);
			dibujar();
			try {sleep(100);} catch (Exception e) {}
			if(hit) {
				borrar();
				try {
					sleep(5000); 
					hit = false; 
					posx = 0;
				} catch(Exception e) {}
			}
			if(posx >= 500) {
				try{
					sleep(5000); //Spaceship appears every 5 seconds
					posx = 0;
				} catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
		}

	}
}
