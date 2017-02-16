import java.awt.*;
import java.util.Random;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class box extends Rectangle {
	
	public boolean isEndPoint = false;
	public int pathPos;
	
	public box(double x, double y, int length){
		super(x,y,length,length);
		this.setFill(Color.GREEN);
		this.setStroke(Color.BLACK);
	}
	
	public int getPathPos(){
		return pathPos;
	}
}
