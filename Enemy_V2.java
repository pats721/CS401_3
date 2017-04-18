package data;
import static helpers.Artist.*;
import org.newdawn.slick.opengl.Texture;

public class Enemy {
	private static final float TILE_SIZE = 64;

	Texture alien = QuickLoad("Fire32");
	
	private Texture texture, backHealth, frontHealth, healthOutline; 
	float x;
	float y;
	float width;
	float hight;
	Tile target;
	Tile[] path;
	public boolean isSpawned = false;
	public boolean alive = true;
	public int currPosition = 1;
	public final float moveSpeed = 2f;
	public Tile endPoint;
	private int index;
	private float health = 4, healthStart;
	private boolean gotPoints = false;
	public Enemy(Tile spawn, Tile endPoint, Tile[] path){
		this.backHealth = QuickLoad ("backHealth");
		this.frontHealth = QuickLoad ("frontHealth");
		this.healthOutline = QuickLoad ("healthOutline");
		this.x = spawn.getX();
		this.y = spawn.getY();
		this.width = spawn.getWidth();
		this.hight = spawn.getHight();
		this.path = path;
		this.endPoint = endPoint;
		this.index = 0;
		this.healthStart = health;
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
		float healthTotal = health / healthStart;
		DrawQuadTex(this.alien, x, y, width, hight);
		DrawQuadTex(backHealth, x, y - 14, width, 7);
		DrawQuadTex(frontHealth, x, y - 14, TILE_SIZE * healthTotal, 7);
		DrawQuadTex(healthOutline, x, y - 14, width, 7);
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
	
	public float getHealth(){
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
}
