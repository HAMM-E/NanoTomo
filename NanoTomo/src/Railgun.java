import java.awt.geom.Point2D;

public class Railgun extends Weapon{
	public Railgun() {
		super("Railgun", 1.25, 3);
	}

	@Override
	public void Fire(Point2D startPosition, Point2D endPosition, int damage) {
		System.out.printf("Shooting (%f,%f) from (%f,%f) and dealing damage %d",
				endPosition.getX(), endPosition.getY(),
				startPosition.getX(), startPosition.getY(),
				damage);
	}
}
