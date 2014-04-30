package morphgame;

import java.awt.Rectangle;


public class MainCharacter {


	// Constants are Here

	final int GROUND = 382;
		
	private int moveSpeed = 5;
	
	private int centerX = 100;
	private int centerY = GROUND;
	private boolean jumped = false;
	private boolean ducked = false;
	private boolean movingLeft = false;
	private boolean movingRight = false;
	private boolean touchingSpikes = false;

	public static Rectangle rect = new Rectangle(0, 0, 0, 0);
	public static Rectangle rect2 = new Rectangle(0, 0, 0, 0);
	public static Rectangle rect3 = new Rectangle(0, 0, 0, 0);
	public static Rectangle rect4 = new Rectangle(0, 0, 0, 0);
	public static Rectangle yellowRed = new Rectangle(0, 0, 0, 0);
	public static Rectangle footleft = new Rectangle(0, 0, 0, 0);
	public static Rectangle footright = new Rectangle(0, 0, 0, 0);

	private static Background bg1 = StartingClass.getBg1();
	private static Background bg2 = StartingClass.getBg2();

	private int jumpSpeed = -15;
	private int speedX = 0;
	private int speedY = 0;
	private int score = 0;
	private String morph;

	public void respawn() {
		
	}
	
	public void update() {
		// Moves Character or Scrolls Background accordingly.

		if (speedX < 0) {
			centerX += speedX;
		}
		if (speedX == 0 || speedX < 0) {
			bg1.setSpeedX(0);
			bg2.setSpeedX(0);

		}
		if (centerX <= 200 && speedX > 0) {
			centerX += speedX;
		}
		if (speedX > 0 && centerX > 200) {
			score+=speedX;
			bg1.setSpeedX(-moveSpeed / 5);
			bg2.setSpeedX(-moveSpeed / 5);
		}

		// Updates Y Position
		centerY += speedY;

		// Handles Jumping

		speedY += 1;

		if (speedY > 3) {
			jumped = true;
		}

		// Prevents going beyond X coordinate of 0
		if (centerX + speedX <= 60) {
			centerX = 61;
		}
		//use characteristics of the new morph
		if(getMorph().equals("square")){
			square();
		}if(getMorph().equals("circle")){
			circle();
		}if(getMorph().equals("balloon")){
			balloon();
		}
	}
	
	private void circle(){
		//will change character collision boxes later
		squareCollison();
		setMoveSpeed(10);
	}
	
	//will change character collision boxes later
	private void circleCollison() {
		
	}
	
	private void square(){
		squareCollison();
		setMoveSpeed(5);
	}
	public void squareCollison(){
		rect.setRect(centerX - 34, centerY - 63, 68, 63);
		rect2.setRect(rect.getX(), rect.getY() + 63, 68, 63);
		rect3.setRect(rect.getX() - 26, rect.getY() + 32, 26, 20);
		rect4.setRect(rect.getX() + 68, rect.getY() + 32, 26, 20);
		yellowRed.setRect(centerX - 110, centerY - 110, 180, 180);
		footleft.setRect(centerX - 50, centerY + 20, 50, 15);
		footright.setRect(centerX, centerY + 20, 50, 15);
	}
	private void balloon(){
		speedY=-1;
		setMoveSpeed(5);
		//place holder
		squareCollison();
		
	}
	public void setMorph(String a){
		morph =a;
	}
	public String getMorph(){
		return morph;
	}
	public boolean isDucked() {
		return ducked;
	}
	
	public void setDucked(boolean ducked) {
		this.ducked = ducked;
	}

	public void moveRight() {
		if (ducked == false) {
			speedX = moveSpeed;
		}
	}

	public void moveLeft() {
		if (ducked == false) {
			speedX = -moveSpeed;
		}
	}
	
	public void stopRight() {
		setMovingRight(false);
		stop();
	}

	public void stopLeft() {
		setMovingLeft(false);
		stop();
	}

	private void stop() {
		if (isMovingRight() == false && isMovingLeft() == false) {
			speedX = 0;
		}
		if (isMovingRight() == false && isMovingLeft() == true) {
			moveLeft();
		}

		if (isMovingRight() == true && isMovingLeft() == false) {
			moveRight();
		}
	}

	private int getMoveSpeed() {
		return moveSpeed;
	}

	public void jump() {
		if (jumped == false) {
			speedY = jumpSpeed;
			jumped = true;
		}

	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public boolean isJumped() {
		return jumped;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getSpeedY() {
		return speedY;
	}
	
	public boolean getTouchingSpikes(){
		return touchingSpikes;
	}
	public void setMoveSpeed(int a){
		moveSpeed = a;
	}
	public void setTouchingSpikes(boolean touchingSpikes){
		this.touchingSpikes = touchingSpikes;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setJumped(boolean jumped) {
		this.jumped = jumped;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public boolean isMovingRight() {
		return movingRight;
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public boolean isMovingLeft() {
		return movingLeft;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}

	public int getJumpSpeed() {
		return jumpSpeed;
	}

	public void setJumpSpeed(int jUMPSPEED) {
		jumpSpeed = jUMPSPEED;
	}
	public int getScore(){
		return score/100;
	}



}
