import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.lang.invoke.VarHandle;

public abstract class Character {
	protected String name;
	protected int health;
	protected int baseDamage;
	protected Point2D.Double position;
	protected Weapon weapon;
	protected Dimension size;
	
	public Character() {
		this.name = "Damager";
		this.health = 20;
		this.baseDamage = 4;
		this.position = new Point2D.Double(0,0);
		this.weapon = new Canon();
		this.size = new Dimension(40, 40);
	}
	
	public Character(String name) {
		this.name = name;
		this.health = 20;
		this.baseDamage = 4;
		this.position = new Point2D.Double(0,0);
		this.weapon = new Canon();
		this.size = new Dimension(40, 40);
	}
	
	public Character(String name, int health, int baseDamage, Point2D.Double position, Weapon weapon) {
		this.name = name;
		this.health = health;
		this.baseDamage = baseDamage;
		this.position = position;
		this.weapon = weapon;
		this.size = new Dimension(40, 40);
	}
	
	public String GetName() {
		return this.name;
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	
	public int GetHealth() {
		return this.health;
	}
	
	public void TakeDamage(int damage) {
		this.health -= damage;
	}
	
	public void Heal(int recoveredHealth) {
		this.health += recoveredHealth;
	}
	
	public Point2D.Double GetPosition(){
		return this.position;
	}
	
	public void SetPosition(Point2D.Double position) {
		this.position = position;
	}
	
	public Weapon GetWeapon() {
		return this.weapon;
	}
	
	public void SetWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public Dimension GetSize() {
		return this.size;
	}
	
	public void SetSize(Dimension size) {
		this.size = size;
	}
	
	public abstract void Attack(Point2D.Double target);
}
