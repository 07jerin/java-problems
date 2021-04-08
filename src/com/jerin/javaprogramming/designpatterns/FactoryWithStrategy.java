package com.jerin.javaprogramming.designpatterns;

public class FactoryWithStrategy {

	public static void main(String[] args) {
		FactoryWithStrategy.strategyDraw(FactoryWithStrategy.getShape(1));
		FactoryWithStrategy.strategyDraw(FactoryWithStrategy.getShape(2));
	}

	public static Shape getShape(int type) {
		Shape s = null;
		switch (type) {
		case 1:
			s = new Circle();
			break;
			
		case 2:
			s = new Square();
			break;

		default:
			// Log error
			break;
		}
		return s;
	}

	public static void strategyDraw(Shape shape) {
		shape.draw();
	}

}

interface Shape {
	public void draw();
}

class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Circle");

	}

}

class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("Square");

	}

}
