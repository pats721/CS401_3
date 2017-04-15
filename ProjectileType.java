package GameObjects;

import org.newdawn.slick.opengl.Texture;

public enum ProjectileType {
	Squirt("shootwater", 1, 10), Lightning("bolt32", 1, 10), Volcono("Fire32", 1, 10); 

	String texture;
	int basedamage;
	int maxdamage;
	
	ProjectileType(String tex, int basedamage, int maxdamage) {
		texture = tex;
		this.basedamage = basedamage;
		this.maxdamage = maxdamage;
	}
}
