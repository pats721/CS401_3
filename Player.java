package data;

import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import static helpers.Artist.*;

import GameObjects.Tower;
import GameObjects.TowerType;

public class Player {

	private TileGrid grid;
	private TileType[] types;
	private int index;
	private WaveController waveController;
	private ArrayList<Tower> towerList;
	private ArrayList<Enemy> enemyList;

	public Player(TileGrid grid, WaveController waveController, ArrayList<Enemy> enemies) {
		this.grid = grid;
		this.types = new TileType[3];
		this.index = 0;
		this.waveController = waveController;
		this.towerList = new ArrayList<Tower>();
		this.enemyList = enemies;
	}

	public void setTile() {
		grid.SetTile((int) Math.floor(Mouse.getX() / 64), (int) Math.floor((HEIGHT - Mouse.getY() - 1) / 64),
				types[index]);
	}

	public void update() {
		for (Tower t : towerList) {
			t.update();
		}
		// Mouse Input.
		if (Mouse.isButtonDown(0)) {
			setTile();
		}

		// Keyboard Input.
		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
				moveIndex();
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
				moveIndex();
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_T && Keyboard.getEventKeyState()) {
				towerList.add(new Tower("fkghhg", grid.GetTile(18, 9), TowerType.Basic, this.enemyList));
			}
		}
	}

	private void moveIndex() {
		index++;
		if (index > types.length - 1) {
			index = 0;
		}
	}
}
