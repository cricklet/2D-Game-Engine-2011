package rts.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import entities.Entity;
import events.entities.EntityEvent;
import graphics.sprites.Sprite;

public abstract class RTSStaticEntity extends Entity implements RTSEntity {
	
	private double health;
	private Type type;
	private boolean selected;
	
	public RTSStaticEntity(String name, int x, int y, int width, int height) {
		super(name, x, y, width, height);
	}

	public abstract void draw(int x, int y, Graphics2D g);

	public void drawOutline(int x, int y, Graphics2D g) {
		g.setColor(getOutlineColor());
		g.drawRect(x-2, y-2, (int) getWidth() + 4, (int) getHeight() + 4);
	}
	public abstract Color getOutlineColor();

	public abstract void think();

	public abstract void EntityEventReceived(EntityEvent event);
	
	public Type getType() {
		return type;
	}
	
	public double getHealth() {
		return health;
	}
	
	public double takeHealth(double dh) {
		health -= Math.abs(dh);
		return Math.abs(dh);
	}

	public void giveHealth(double dh) {
		health += Math.abs(dh);
	}

	public boolean isSelected() { return selected; }
	
	public void select(boolean selected) { this.selected = selected; }

}
