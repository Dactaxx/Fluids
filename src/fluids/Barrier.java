package fluids;

import java.awt.Graphics2D;

public class Barrier {
	private double x, y, size, xvel, yvel, mass;
	public Barrier(double x, double y) {
		this.x = x;
		this.y = y;
		this.size = 20;
		this.xvel = 0;
		this.yvel = 0;
		this.mass = 100;
		
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getXvel() {
		return xvel;
	}

	public void setXvel(double xvel) {
		this.xvel = xvel;
	}

	public double getYvel() {
		return yvel;
	}

	public void setYvel(double yvel) {
		this.yvel = yvel;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public void render(Graphics2D g2d) {
		g2d.fillRect((int)(this.x - this.size), (int)(this.y - this.size), (int)(this.size * 2), (int)(this.size * 2));
		
	}
	
}
