package data;

import java.util.ArrayList;

import GameObjects.Tower;
import GameObjects.TowerType;
import helpers.Clock;

public class CreateGame {
	Level level;
	GameHandler game;
	Spawn enemySpawn;
	ArrayList<Tower> towerList;
	TileGrid grid;
	WaveController wavecon;
	Player user;
	
	public CreateGame(){
		Level level = new Level();
		level.nextLevel();
		
		this.enemySpawn = new Spawn(level.getMaxEnemy());
		this.grid = new TileGrid(level.getMap());
		this.game = new GameHandler(grid.getPath(), grid.getTileMap(), enemySpawn, grid.getSpawnPoint(), grid.getEndPoint(), level);
		this.wavecon = new WaveController(this.level, this.enemySpawn);
		this.user = new Player(this.grid, this.wavecon, this.enemySpawn.getEnemyList());
	}
	
	public void update(){
		Clock.update();
		grid.Draw();
		
		game.Update();
		game.Movement();
		
		user.update();
		
	}
}
