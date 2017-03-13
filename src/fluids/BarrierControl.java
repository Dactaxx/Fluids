package fluids;

import java.util.ArrayList;
import java.awt.Graphics2D;

public class BarrierControl {
	public static ArrayList<Barrier> barriers = new ArrayList<Barrier>();
	public static void render(Graphics2D g2d) {
		for(Barrier b : barriers) {
			b.render(g2d);
			
		}
	}
	
}
