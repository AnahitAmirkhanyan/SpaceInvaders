import java.awt.*;

class Puntos extends Thread{
	Graphics g;
	int x = 430;
	int y= 280;
	int p = 0;
	public Puntos(Graphics g){
		this.g=g;
	}
		
	public void run(){
		
		while(true){
//     		g.setColor(Color.black);
//     		g.drawString("Points="+p,x,y);
     		
			g.setColor(Color.white);
			g.drawString("Points : "+p,x,y);
		try {
       	 	    Thread.sleep(10);
       		  } catch(InterruptedException E){
       	  } 
//			g.setColor(Color.black);
//			g.drawString("Points="+p,x,y);
			
		}
	}
	void Bingo(int point){
		g.setColor(Color.black);
    	g.drawString("Points : "+p, x ,y);
		p += point;
	}
	
}
			
		
		