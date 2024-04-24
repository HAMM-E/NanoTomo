import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.lang.annotation.Target;
import java.util.Timer;
import java.util.TimerTask;

import org.w3c.dom.css.CSSStyleDeclaration;

public class Canon extends Weapon{
	private Point2D.Double bulletPosition;
	private Timer timer;
	private boolean destinationReached;
	private Point2D.Double destination;	
	private TimerTask task;
	private int speed;
	private int timePassed;
	private final int delay;
	private final int timeLimit;
	private double stepX;
	private double stepY;
	
	public Canon() {
		super("Canon", 2.0, 2);	
		this.bulletPosition = null;
		this.destination = null;
		this.destinationReached = false;
		this.speed = 50;
		this.delay = 50;
		this.timePassed = 0;
		this.timeLimit = 5000;
		this.timer = new Timer();
		this.task = new TimerTask() {			
			@Override
			public void run() {
				if(GameHandler.TargetHit(playerOwned, bulletPosition) || timePassed >= timeLimit) {
					timer.cancel();
					timePassed = 0;
					System.out.println("Arrived!");
				}
				else {
					IncrementBulletPosition(stepX, stepY);
					timePassed += delay/speed;
				}
			}
		};
	}
	
	@Override
	public void Fire(Point2D startPosition, Point2D endPosition, int damage) {
		this.destinationReached = false;
		this.bulletPosition  = (Double) startPosition;
		this.destination = (Double) endPosition;
		stepX = (this.destination.getX() - this.bulletPosition.getX());
		stepY = (this.destination.getY() - this.bulletPosition.getY());
		double stepSum = Math.abs(stepX + stepY);
		stepX = (stepX/stepSum);
		stepY = (stepY/stepSum);
		this.timer.schedule(task, 0, this.delay/this.speed);
	}
	
	private void IncrementBulletPosition(double incrementX, double incrementY) {
		this.bulletPosition = new Point2D.Double(this.bulletPosition.getX() + stepX, this.bulletPosition.getY() + stepY);
		System.out.println(String.format("My bullet is at (%6.2f,%6.2f) moving to (%6.2f,%6.2f)", this.bulletPosition.getX(), this.bulletPosition.getY(), this.destination.getX(), this.destination.getY()));
	}
	
	public static void main(String[] args) {
		Canon c = new Canon();
		GameHandler.InitializeGame(1);
		GameHandler.GetNanoBots().get(0).SetPosition(new Point2D.Double(48,75));
		c.Fire(new Point2D.Double(0,0), new Point2D.Double(100,150), 5);
	}
}
