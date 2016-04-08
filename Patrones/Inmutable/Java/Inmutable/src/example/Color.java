package example;

public class Color {
	private int R;
	private int G;
	private int B;
	
	public Color(int r, int g, int b){
		this.R = r;
		this.G = g;
		this.B = b;		
	}
	
	public int getR(){
		return this.R;
	}
	
	public int getG(){
		return this.G;
	}
	
	public int getB(){
		return this.B;
	}
	
	public String toString(){
		return this.R + "," + this.G + "," + this.B;
	}
}
