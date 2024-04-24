import java.awt.Dimension;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class GameHandler {
	private static Player player;
	private static ArrayList<Nanobot> nanobots = new ArrayList<Nanobot>();
	
	public static void InitializeGame(int numOfBots) {
		player = new Player("Player");
		for(int i = 0; i < numOfBots; i++) {
			nanobots.add(new Nanobot(String.format("Nanobot %d", i + 1)));
		}
	}
	
	public static Player GetPlayer() {
		return player;
	}
	
	public static ArrayList<Nanobot> GetNanoBots(){
		return nanobots;
	}
	
	public static boolean TargetHit(boolean isPlayer, Point2D.Double hitPosition) {
		if(isPlayer) {
			for(int i = 0; i < nanobots.size(); i++) {
				Point2D.Double nbPosition = nanobots.get(i).GetPosition();
				Dimension nbSize = nanobots.get(i).GetSize();
				int[] xCoords = {(int) nbPosition.x, (int) nbPosition.x + nbSize.width, (int) nbPosition.x + nbSize.width, (int) nbPosition.x};
				int[] yCoords = {(int) nbPosition.y, (int) nbPosition.y + nbSize.height, (int) nbPosition.y + nbSize.height, (int) nbPosition.y};
				Polygon hitBox = new Polygon(xCoords, yCoords, 4);
				if(hitBox.getBounds().contains(hitPosition)) return true;
			}
		} else {
			Point2D.Double nbPosition = player.GetPosition();
			Dimension nbSize = player.GetSize();
			int[] xCoords = {(int) nbPosition.x, (int) nbPosition.x + nbSize.width, (int) nbPosition.x + nbSize.width, (int) nbPosition.x};
			int[] yCoords = {(int) nbPosition.y, (int) nbPosition.y + nbSize.height, (int) nbPosition.y + nbSize.height, (int) nbPosition.y};
			Polygon hitBox = new Polygon(xCoords, yCoords, 4);
			if(hitBox.getBounds().contains(hitPosition)) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		GameHandler.InitializeGame(3);
		GameHandler.nanobots.get(0).SetPosition(new Point2D.Double(80,50));
		GameHandler.player.SetPosition(new Point2D.Double(1000,100));
		GameHandler.GetNanoBots().get(0).Attack(new Point2D.Double(1000, 115));
	}
}
