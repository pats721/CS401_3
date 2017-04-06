package data;

public class Spawn {
	public Enemy[] enemies = new Enemy[99];
	public int enemyCount;
	public int maxEnemy;
	public Tile spawn;
	public Tile[] path;
	
	public Spawn(int maxEnemyCount){
		this.enemyCount = 0;
		this.maxEnemy = 1;
	}
	
	public void SpawnEnemy(Tile spawn, Tile[] path){
		this.spawn = spawn;
		this.path = path;
		if(enemyCount < maxEnemy){
			enemies[enemyCount] = new Enemy(spawn, path);
			System.out.println("Enemy" + enemyCount + ":" + enemies[enemyCount]);
			enemyCount++;
		}
	}
	
	public void Move(){
		for(int i = 0; i < enemyCount; i++){
			enemies[i].move();
		}
	}
	public int GetEnemyCount(){
		return enemyCount;
	}
}
