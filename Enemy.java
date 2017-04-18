package data;
import static helpers.Artist.*;
import org.newdawn.slick.opengl.Texture;

import helpers.Artist;
public class Enemy {
	Texture alien = QuickLoad("Fire32");
	
	float x;
	float y;
	float width;
	float hight;
	Tile target;
	Tile[] path;
	public boolean isSpawned = false;
	public boolean alive = true;
	public int currPosition = 1;
	public final float moveSpeed = 4f;
	public Tile endPoint;
	private int health = 4;
	private int index;
	private boolean gotPoints = false;
	private boolean attacked = false;
	public Enemy(Tile spawn, Tile endPoint, Tile[] path){
		this.x = spawn.getX();
		this.y = spawn.getY();
		this.width = spawn.getWidth();
		this.hight = spawn.getHight();
		this.path = path;
		this.endPoint = endPoint;
		this.index = 0;
		DrawQuadTex(this.alien, x, y, width, hight);
	}
	
	public void move(){
			if(this.x < this.path[currPosition].getX()){
				this.x = this.x + moveSpeed;
				if(this.y < this.path[currPosition].getY()){	
						this.y = this.y + moveSpeed;
					}
					else if(this.y > this.path[currPosition].getY()){
						this.y = this.y - moveSpeed;
					}
				}
				else if(this.x > this.path[currPosition].getX()){
					this.x = this.x - moveSpeed;
					if(this.y < this.path[currPosition].getY()){
						this.y = this.y + moveSpeed;
					}
					else if(this.y > this.path[currPosition].getY()){
						this.y = this.y - moveSpeed;
					}
				}
				else{
					if(this.y < this.path[currPosition].getY()){
						this.y = this.y + moveSpeed;
					}
					else if(this.y > this.path[currPosition].getY()){
						this.y = this.y - moveSpeed;
					}else{
						currPosition++;
				}
			}
		}
	public void DrawEnemy(){
		DrawQuadTex(this.alien, x, y, width, hight);
	}
	public Tile GetTarget(){
		return this.target;
	}
	
	public void SetTarget(Tile target){
		 this.target = target;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public float getX(){
		return this.x;
	}
	
	public float getY(){
		return this.y;
	}
	
	public int getCurrPosition(){
		return currPosition;
	}
	
	public boolean isAlive(){
		return alive;
	}
	
	public void die(){
		this.alive = false;
		
	}
	
	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHight() {
		return hight;
	}

	public void setHight(float hight) {
		this.hight = hight;
	}
	
	public void setHealth(int dmg){
		this.health -= dmg;
	}
	
	public int getHealth(){
		return this.health;
	}
	
	public void setIndex(int index){
		this.index = index;
	}
	
	public int getIndex(){
		return this.index;
	}
	
	public void gotPoints(){
		this.gotPoints = true;
	}
	
	public boolean getGotPoints(){
		return this.gotPoints;
	}
	public int attackBase(){
		this.attacked = true;
		return 1;
	}
	public boolean getAttacked(){
		return this.attacked;
	}
}
