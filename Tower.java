package GameObjects;

import org.newdawn.slick.opengl.Texture;
import java.util.Random;

import static helpers.Artist.*;

import data.*;

public class Tower {
	final static int MAXLEVEL = 5;
		
	private String name;
	private	int baseattack;
	private	int maxattack;
	private double range;
	private int tcost;
	private int upcost;
	private int level;
	private Texture texture;
	private TowerType type;
	private Tile startTile;
	private float x, y, width, hight; 
		
	public Tower(String name, Tile startTile, TowerType type){
		this.name = name;
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.type = type;
		this.baseattack = type.baseattack;
		this.maxattack = type.maxattack;
		this.tcost = type.tcost;
		this.upcost = type.upcost;
		this.level = 1;
		this.texture = QuickLoad(type.texture);
		this.range = type.range;
		this.width = startTile.getWidth();
		this.hight = startTile.getHight();
		}

	public void DrawTower(){
		DrawQuadTex(this.texture, this.x, this.y, this.width, this.hight);
	}
		

	public int Attack() {
		Random rand = new Random();
		return rand.nextInt(this.maxattack) + this.baseattack;
	}

	public void UpgradeTower() throws MaxLevelReachedException {
		if (this.level != MAXLEVEL) {
			this.level = this.level + 1;
			this.baseattack = this.baseattack + 5;
			this.maxattack = this.maxattack + 5;
		} else {
				throw new MaxLevelReachedException();
		}
		
	}
	public int getTcost() {
		return tcost;
	}

	public double getRange() {
		return range;
	}

	public int getUpcost() {
		return upcost;
	}


}
