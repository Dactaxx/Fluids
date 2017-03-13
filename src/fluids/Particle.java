package fluids;

import java.awt.Graphics2D;

public class Particle {
	private double x, y, xvel, yvel, size, mass;
	public Particle(double x, double y, double xvel, double yvel) {
		this.x = x;
		this.y = y;
		this.xvel = xvel;
		this.yvel = yvel;
		this.size = 1;
		this.mass = 2;
	}
	
	public void tick() {
		this.yvel += .0002;
		for(Particle p : ParticleControl.particles) {
			double distance = Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
			if(!p.equals(this) && distance < this.size + p.size) {
				this.xvel = -(this.xvel * (this.mass - p.mass) + (2 * p.mass * p.xvel)) / (this.mass + p.mass);
				this.yvel = -(this.yvel * (this.mass - p.mass) + (2 * p.mass * p.yvel)) / (this.mass + p.mass);
				
			}
		}
		
		for(Barrier b : BarrierControl.barriers) {
			if(Math.abs(this.x - b.getX()) <= b.getSize() && Math.abs(this.y - b.getY()) <= b.getSize()) {
				double rx = this.x - b.getX();
				double ry = -(this.y - b.getY());
				double energyLoss = -1;
				if(ry >= 0 && rx >= -ry && rx >= ry) {
					this.yvel *= -energyLoss;
					this.xvel *= energyLoss;
				}
				if(ry <= 0 && rx <= ry && rx <= -ry) {
					this.yvel *= -energyLoss;
					this.xvel *= energyLoss;
				}
				if(rx >= 0 && ry >= -rx && ry <= rx) {
					this.xvel *= -energyLoss;
					this.yvel *= energyLoss;
				}
				if(rx <= 0 && ry >= rx && ry >= -rx) {
					this.xvel *= -energyLoss;
					this.yvel *= energyLoss;
				}
			}
		}
		
		this.y += yvel;
		this.x += xvel;
		
	}
	
	public void render(Graphics2D g2d) {
		g2d.fillOval((int)(this.x - this.size), (int)(this.y - this.size), (int)(this.size * 2), (int)(this.size * 2));
		
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
	
}
