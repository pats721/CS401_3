package GameObjects;

public enum TowerType {
	Basic("poop", 1.0, 5, 3, 1, 10);
	
	String texture;
	double range;
	int tcost;
	int upcost;
	int baseattack;
	int maxattack;
	
	TowerType(String texture, double range, int tcost, int upcost, int baseattack, int maxattack) {
		this.texture = texture;
		this.range = range;
		this.tcost = tcost;
		this.upcost = upcost;
		this.baseattack = baseattack;
		this.maxattack = maxattack;
	}
}
