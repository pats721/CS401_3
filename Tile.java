package data;

import org.newdawn.slick.opengl.Texture;

public class Tile {
	
	private float x, y, width, hight;
	private Texture texture;
	
	public Tile(float x, float y, float width, float hight, Texture texture) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.hight = hight;
		
	}
}
