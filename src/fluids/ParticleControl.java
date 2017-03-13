package fluids;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class ParticleControl {
	public static ArrayList<Particle> particles = new ArrayList<Particle>();
	
	public static void tick() {
		for(Particle p : particles) {
			p.tick();
		}
	}
	
	public static void render(Graphics2D g2d) {
		for(Particle p : particles) {
			p.render(g2d);
		}
	}
	
}
