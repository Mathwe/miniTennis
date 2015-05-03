package miniTennis;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
	private static final int Ydisplacement = 30;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
	int x = 0;
	int xa = 0;
	private Game game;
	
	public Racquet(Game game) {
		this.game = game;
	}
	
	public void move(){
		if (x + xa > 0 && x + xa < game.getWidth() - 60)
			x = x + xa;
	}
	
	public void paint (Graphics2D g){
		g.fillRect(x, game.getHeight() - Ydisplacement,  60,  10);
	}
	
	public void keyReleased(KeyEvent e) {
		xa = 0;
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			xa = game.speed * -1;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			xa = game.speed * 1;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, game.getHeight() - Ydisplacement, WIDTH, HEIGHT);
	}
	
	public int getTopY() {
		return game.getHeight() - Ydisplacement;
	}

}
