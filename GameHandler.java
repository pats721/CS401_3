package data;

import org.lwjgl.Sys;

public class GameHandler {
	Tile[] path;
	Tile[][] map;
	Spawn spawner;
	Tile spawnPoint;
	public int maxEnemyCount;
	public int enemyCount;
	
	private static long lastFrame;
	private static long getTime(){
		return(Sys.getTime() * 1000)/Sys.getTimerResolution();
	}
	private static double getDelta(){
		long currentTime = getTime();
		double delta = (double) currentTime - (double) lastFrame;
		lastFrame = getTime();
		return delta;
	}
	
	public GameHandler(Tile[] path, Tile[][] map, Spawn spawner, Tile spawnPoint){
		this.path = path;
		this.map = map;
		this.spawner = spawner;
		this.maxEnemyCount = spawner.GetEnemyCount();
		this.enemyCount = 0;
		this.spawnPoint = spawnPoint;
		Spawn();
	}	
	
	public void Spawn(){
		//if(getDelta()%2 ==0){
		spawner.SpawnEnemy(spawnPoint, path);
		//}
	}
	
	public void Movement(){
		//if(getDelta()%2 == 0){
		spawner.Move();
		//}
	}
}
