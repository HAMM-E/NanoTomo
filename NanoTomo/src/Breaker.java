import java.awt.geom.Point2D;
import java.util.Timer;
import java.util.TimerTask;

public class Breaker {
	private final int baseHealth;
	private final int botDisableTime;
	private int health;
	private double recoveryRate;
	private Point2D.Double position;
	
	private Timer timer;
	private TimerTask botPulse;
	private int timePassed;
	
	public Breaker(){
		this.baseHealth = 5;
		this.health = this.baseHealth;
		this.recoveryRate = 2.5;
		this.position = new Point2D.Double(0,0);
		
		this.timer = new Timer();
		this.botDisableTime = 5000;
		this.botPulse = new TimerTask() {			
			@Override
			public void run() {
				if(timePassed <= botDisableTime) {
					GameHandler.EnableBots();
				}
			}
		};
	}
	
	public Breaker(int health, double recoveryRate, Point2D.Double position) {
		this.baseHealth = 5;
		this.health = health;
		this.recoveryRate = recoveryRate;
		this.position = position;
		
		this.timer = new Timer();
		this.botDisableTime = 5000;
		this.botPulse = new TimerTask() {			
			@Override
			public void run() {
				if(timePassed <= botDisableTime) {
					GameHandler.EnableBots();
					timePassed = 0;
					timer.cancel();
				}
				else {
					timePassed += botDisableTime;
				}
			}
		};
	}
	
	public int GetHealth() {
		return health;
	}
	
	public void TakeDamage(int damage) {
		this.health -= damage;
		if(IsDead()) {
			GameHandler.DisableBots();
			timer.schedule(botPulse, botDisableTime);
		}
	}
	
	public boolean IsDead() {
		return this.health <= 0;
	}
	
	public void ResetHealth() {
		this.health = this.baseHealth;
	}
	
	public double GetRecoveryRate() {
		return this.recoveryRate;
	}
	
	public void SetRecoveryRate(double recoveryRate) {
		this.recoveryRate = recoveryRate;
	}
	
	public Point2D.Double GetPosition(){
		return this.position;
	}
	
	public void SetPosition(Point2D.Double position) {
		this.position = position;
	}
	
	public static void main(String[] args) {
		GameHandler.InitializeGame(3);
		Breaker b = new Breaker();
		b.TakeDamage(b.GetHealth());
	}
}
