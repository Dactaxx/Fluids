package fluids;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Fluids extends JPanel implements Runnable {
	public static boolean running = false;
	public static void main(String[] args) {
		Window.createWindow();
		for(int i = 500; i < 1000; i += 20) {
			BarrierControl.barriers.add(new Barrier(i, 500));
		}
		for(int i = 500; i > 0; i -= 20) {
			BarrierControl.barriers.add(new Barrier(500, i));
		}
		for(int i = 500; i > 0; i -= 20) {
			BarrierControl.barriers.add(new Barrier(1000, i));
		}
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 10; j++) ParticleControl.particles.add(new Particle(550 + 3 * i, 3 * j, Math.random() * .1 - .05, 0));
		}
		start();
		
	}
	
	public static synchronized void start() {
		running = true;
		new Thread(new Fluids()).start();
		
	}
	
	public void run() {
		while(running) {
			try {
				Thread.sleep(1);
			} catch(InterruptedException e) {
				
			}
			tick();
			render();
		}
	}
	
	public static void tick() {
		ParticleControl.tick();
	}
	
	public static void render() {
		Window.frame.repaint();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		ParticleControl.render(g2d);
		BarrierControl.render(g2d);
		
	}
}
