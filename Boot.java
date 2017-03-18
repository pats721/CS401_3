package data;

import org.lwjgl.LWJGLException;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;
import static helpers.Artist.*;

public class Boot {
	
	public Boot() {
		
		BeginSession();
		
		Texture tex = LoadTexture("res/mtl18.png", "PNG");
		
		while (!Display.isCloseRequested()){
		
			DrawQuadTex(tex, 0, 0, 64, 64);
			
			Display.update();
			Display.sync(60);
			
			
		}
		Display.destroy();
	}
	
	public static void main(String[] args){
		new Boot();
	}
}
