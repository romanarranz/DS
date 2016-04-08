package example;

public class CircleExample {
	public static void main(String[] args){
		Color azul = new Color(0,0,255);
		Point puntoOrigen = new Point(2.39, 0.12);
		
		double radio = 10.5;
		Circle c = new Circle( radio , azul, puntoOrigen);
		
		System.out.println("Diametro: "+c.getDiameter());
		System.out.println("Radio circunferencia: "+c.getCircumference());
		System.out.println("Color: "+c.getColor());
	}
}
