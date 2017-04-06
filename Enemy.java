package data;
import static helpers.Artist.*;
import org.newdawn.slick.opengl.Texture;

import helpers.Artist;
public class Enemy {
	Texture water = QuickLoad("wtr3");
	
	float x;
	float y;
	float width;
	float hight;
	Tile target;
	Tile[] path;
	public boolean isSpawned = false;
	public int globalPathNum;
	public int currPosition = 1;
	
	public Enemy(Tile spawn, Tile[] path){
		this.x = spawn.getX();
		this.y = spawn.getY();
		this.width = spawn.getWidth();
		this.hight = spawn.getHight();
		this.path = path;
		DrawQuadTex(this.water, x, y, width, hight);
	}
	
	public void move(){
			if(this.x < this.path[currPosition].getX()){
				this.x = this.x + 4;
				if(this.y < this.path[currPosition].getY()){	
						this.y = this.y + 4;
					}
					else if(this.y > this.path[currPosition].getY()){
						this.y = this.y - 4;
					}
				}
				else if(this.x > this.path[currPosition].getX()){
					this.x = this.x - 4;
					if(this.y < this.path[currPosition].getY()){
						this.y = this.y + 4;
					}
					else if(this.y > this.path[currPosition].getY()){
						this.y = this.y - 4;
					}
				}
				else{
					if(this.y < this.path[currPosition].getY()){
						this.y = this.y + 4;
					}
					else if(this.y > this.path[currPosition].getY()){
						this.y = this.y - 4;
					}else{
						currPosition++;
				}
				}
			DrawQuadTex(this.water, x, y, width, hight);
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
	
	public int getGlobalPathNum(){
		return globalPathNum;
	}
}
