package data;

import static helpers.Artist.*;

import java.util.Map;

public class TileGrid {
	
	public Tile[][] tilemap;
	public Tile[] path;
	public Tile spawnPoint;
	public int pathCount = 0;
	public int locPathCount = 0;
	public TileGrid() {
		tilemap = new Tile[20][15];
		for (int i = 0; i < tilemap.length; i++){
			for(int j = 0; j < tilemap[i].length; j++){
				tilemap[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Path);
			}
		}
	}
	public TileGrid(int[][] newtilemap){
		int tilemapLength = 0;
		tilemap = new Tile[20][15];
		int pathCount = 0;
		
		
		int n = 0;
		for (int i = 0; i < tilemap.length; i++){
			for(int j = 0; j < tilemap[i].length; j++){
				if(newtilemap[j][i]>=1){
					n++;
				}
			}
			
		}
		path = new Tile[n];
		for (int i = 0; i < tilemap.length; i++){
			for(int j = 0; j < tilemap[i].length; j++){
				
				if(newtilemap[j][i] == 0){
					tilemap[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Water);
					System.out.println(tilemap[i][j]);
				}
				else if(newtilemap[j][i] >= 1){
					tilemap[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Path);
					tilemap[i][j].setIdNum(newtilemap[j][i]);
					System.out.println(tilemap[i][j]);
					if(tilemapLength == 0){
						spawnPoint = tilemap[i][j];
						
					}
					path[pathCount]= tilemap[i][j];
					path[pathCount] = tilemap[i][j];
					pathCount++;
					tilemapLength++;
				}		
			}
		}
		sortPath();
		print();
	}
	
	public void Draw(){
		for (int i = 0; i < tilemap.length; i++){
			for(int j = 0; j < tilemap[i].length; j++){
				if(tilemap[i][j] != null){
					Tile t = tilemap[i][j];
					DrawQuadTex(t.getTexture(), t.getX(), t.getY(), t.getWidth(), t.getHight()); 
				}else{
					System.out.println(tilemap[i][j]);
				}
			}
		}
	}
	public void sortPath(){
        Tile temp;  
         for(int i=0; i < path.length; i++){  
              for(int j=1; j < path.length; j++){
                   if(path[j-1].idNum > path[j].idNum){  
                         //swap elements  
                          temp = path[j-1];  
                          path[j-1] = path[j];  
                          path[j] = temp;
                                 
                   }       
              }  
         }
	}
	
	public void print(){
		for(int i=0; i < path.length; i++){  
            	System.out.println(path[i].getIdNum());         
        }
	}	
	
	public void SetTile(int xCord, int yCord, TileType type){
		tilemap[xCord][yCord] = new Tile(xCord * 64, yCord * 64, 64, 64, type);
	}
	
	public Tile GetTile(int xCord, int yCord){
		return tilemap[xCord][yCord];
	}
	public Tile[][] getTileMap(){
		return tilemap;
	}
	public Tile[] getPath(){
		return path;
	}
	public Tile getSpawnPoint(){
		return spawnPoint;
	}
}
