import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.Scanner;

public class Player extends Character{
	private int speed;
	
	public Player() {
		super();
		this.speed = 10;
	}
	
	public Player(String name) {
		super(name);
		this.speed = 10;
	}
	
	public Player(String name, int health, int damage, int speed, Point2D.Double position, Weapon weapon) {
		super(name, health, damage, position, weapon);
		this.speed = speed;
	}
	
	public void Move(int horizontal, int vertical) {
		this.position = new Point2D.Double(this.GetPosition().getX() + horizontal,
				this.GetPosition().getY() + vertical);
	}

	@Override
	public void Attack(Double target) {
		this.weapon.Fire((Point2D) this.position.clone(), target, this.baseDamage);
	}
	
	@Override
	public String toString() {
		String description = String.format("Name: %s Health: %d Damage: %d Speed: %d Position: (%f,%f) Weapon: %s", 
				this.name, this.health, this.baseDamage, this.speed, this.position.getX(), this.position.getY(), this.weapon.GetName());
		return description;
	}
	
	public static void main(String[] args) {
		Player me = new Player("Ethan");
		me.Move(0, 10);
		me.SetWeapon(new Canon());
		me.Attack(new Point2D.Double(50,50));
		System.out.println(me);
	}
}
