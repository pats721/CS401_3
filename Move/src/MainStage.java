import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

import java.awt.Button;
import java.awt.Font;
import java.time.*;

import javafx.animation.*;

public class MainStage extends Application{
	public int moveX = 5;
	public int moveY = 5;
	box wayPoint;
	box spawnPoint;;
	box endPoint;
	int health = 10;
	String hearts = "";
	

	int loc = 0;
	double dX;
    double dY;

	box r;
	
	box[] path = new box[17];
	int[] grid = {0,0,0,0,0,0,0,0,0,0,
			   0,1,2,0,0,0,0,0,0,0,
			   0,0,3,0,0,0,0,0,17,0,
			   0,5,4,0,0,0,0,15,16,0,
			   0,6,0,0,0,0,13,14,0,0,
			   0,7,8,9,10,11,12,0,0,0,
			   0,0,0,0,0,0,0,0,0,0,
			   0,0,0,0,0,0,0,0,0,0,
			   0,0,0,0,0,0,0,0,0,0,
			   0,0,0,0,0,0,0,0,0,0};
	
	public int locCount = 0;
	public boolean isAlive = true;
	
	public static void main(String[] args){
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage){
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, 550,650);	
		stage.setScene(scene);
		scene.setRoot(root);
		createGrid(root);
		bubbleSort();
		endPoint = path[path.length-1];
		hearts = Integer.toString(health);
		Text text = new Text(50, 550, "Health: " + hearts);

        text.setFill(Color.BLACK);
        root.getChildren().add(text);
		for(int i = 0; i < path.length; i++){

			System.out.println(path[i]);
		}
		for(int i = 0; i < path.length; i++){

			System.out.println(path[i].pathPos);
		}
		r = spawnPoint;
		wayPoint = spawnPoint;
		dX = spawnPoint.getX();
		dY = spawnPoint.getY();
		stage.show();

		new AnimationTimer(){
			@Override public void handle(long currentNanoTime){
				try{
					Thread.sleep(50);
					System.out.println("Debug:"+locCount);
					if(isAlive){
						moveBox(root);
					}

					hearts = Integer.toString(health);
					text.setText("Health" + hearts);

				}catch(InterruptedException ex){
					Thread.currentThread().interrupt();
					r.setFill(Color.WHITE);
				}
			}
		}.start();
	}
	public void moveBox(AnchorPane root){

		root.getChildren().removeAll(r);
		if(endPoint.getX() == r.getX() && endPoint.getY() == r.getY()){
			isAlive = false;
			health--;
		}
		if(isAlive){
			if(wayPoint.getX() > r.getX()){
				System.out.println("Enemy movex");
				dX = dX + moveX;
				if(wayPoint.getY() > r.getY()){
					System.out.println("Enemy movey");
					dY = dY + moveY;
				}
				else if(wayPoint.getY() < r.getY()){
					System.out.println("Enemy -movey");
					dY = dY - moveY;
				}else{
					System.out.println("Enemy off screen");
					dY = dY;
				}
			}
			else if(wayPoint.getX() < r.getX()){
				System.out.println("Enemy -movex");
				dX = dX - moveX;
				if(wayPoint.getY() > r.getY()){
					System.out.println("Enemy movey");
					dY = dY + moveY;
				}
				else if(wayPoint.getY() < r.getY()){
					System.out.println("Enemy -movey");
					dY = dY - moveY;
				}else{
					System.out.println("Enemy off screen");
					dY = dY;
				}
			}
			else{
				System.out.println("Enemy off screen");
				dX = dX;

				if(wayPoint.getY() > r.getY()){
					System.out.println("Enemy movey");
					dY = dY + moveY;
				}
				else if(wayPoint.getY() < r.getY()){
					System.out.println("Enemy -movey");
					dY = dY - moveY;
				}else{
					System.out.println("Enemy off screen");
					dY = dY;
					locCount++;
					setWayPoint(root, path[locCount]);	
				}
			}
		
		r.setX(dX);
		r.setY(dY);

		r.setStroke(Color.BLACK);
		r.setFill(Color.RED);
			root.getChildren().add(r);
		}

	}
	
	public void createGrid(AnchorPane root){
		int count = 0;
		box g;
		for(int i = 0; i < 10; i ++){
			for(int j = 0; j < 10; j++){
				if(grid[count] == 0){

					g = new box(j*50,i*50,50);
				}
				else{

					g = new box(j*50,i*50,50);
					g.setFill(Color.BEIGE);
					g.setStroke(Color.BLACK);
					g.pathPos = grid[count];
					if(loc == 0){
						spawnPoint = g;
						path[loc] = g;
						System.out.println(path[loc] + " = " + g);
						loc++;
					}
					else{
						path[loc] = g;
						System.out.println(path[loc] + " !!!! " + g);
						loc++;
					}
				}
				count++;
				root.getChildren().add(g);

			}
		}
	}
	
	public void bubbleSort()
	{
		box temp;
	     for(int i = 0; i < path.length; i++){
				for (int j = 1; j < path.length; j++) {
					System.out.println("path[j]");
					if (path[j-1].getPathPos() > path[j].pathPos){
						temp = path[j-1];
						path[j-1] = path[j];
						path[j] = temp;
					}
				}
	       }
	}
	
	public void setWayPoint(AnchorPane root, box g){
		System.out.println(wayPoint);
		wayPoint = g;
		root.getChildren().add(wayPoint);
	}
}