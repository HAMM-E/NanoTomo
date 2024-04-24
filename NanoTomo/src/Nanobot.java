import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class Nanobot extends Character{
	private boolean canShoot;
	public Nanobot() {
		super();
		this.canShoot = true;
		this.weapon.SetPlayerOwned(false);
	}
	
	public Nanobot(String name) {
		super(name);
		this.canShoot = true;
		this.weapon.SetPlayerOwned(false);
	}
	
	public Nanobot(String name, int health, int baseDamage, Point2D.Double position, Weapon weapon) {
		super(name, health, baseDamage, position, weapon);
		this.canShoot = true;
		this.weapon.SetPlayerOwned(false);
	}
	
	@Override
	public void Attack(Point2D.Double target) {
		if(canShoot)
			this.weapon.Fire(this.position, target, this.baseDamage);
	}
	
	@Override
	public String toString() {
		String description = String.format("Name: %s Health: %d Damage: %d Position: (%f,%f) Weapon: %s", 
				this.name, this.health, this.baseDamage, this.position.getX(), this.position.getY(), this.weapon.GetName());
		return description;
	}
	
	public boolean GetActivity() {
		return this.canShoot;
	}
	
	public void SetActivity(boolean canShoot) {
		this.canShoot = canShoot;
	}
	
	public static void main(String[] args) {
		Nanobot nb = new Nanobot("Nanobot");
		System.out.println(nb);
		nb.Attack(new Point2D.Double(50,100));
	}
}
