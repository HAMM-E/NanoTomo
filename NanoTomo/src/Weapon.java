import java.awt.geom.Point2D;

public abstract class Weapon {
	protected String name;
	protected double damageAmplifier;
	protected int reloadTime;
	protected boolean playerOwned;
	
	public Weapon(String name, double damageAmplifier, int reloadtime) {
		this.name = name;
		this.damageAmplifier = damageAmplifier;
		this.reloadTime = reloadtime;
		this.playerOwned = true;
	}
	
	public abstract void Fire(Point2D startPosition, Point2D endPosition, int damage);
	
	public String GetName() {
		return this.name;
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	
	public Double GetDamageAmplifier() {
		return damageAmplifier;
	}
	
	public void SetDamageAmplifier(double damageAmplifier) {
		this.damageAmplifier = damageAmplifier;
	}
	
	public int GetReloadTime() {
		return this.reloadTime;
	}
	
	public void SetReloadTime(int reloadTime) {
		this.reloadTime = reloadTime;
	}
	
	public boolean GetPlayerOwned() {
		return this.playerOwned;
	}
	
	public void SetPlayerOwned(boolean playerOwned) {
		this.playerOwned = playerOwned;
	}
}
