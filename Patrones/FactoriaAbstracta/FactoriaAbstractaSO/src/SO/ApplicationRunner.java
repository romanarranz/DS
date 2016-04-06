package SO;

import java.util.Scanner;

public class ApplicationRunner {
	public static GUIFactory createOsSpecificFactory(int sys) {
		if (sys == 0) {
			return new WinFactory();
		}
		else {
			return new OSXFactory();
		}
	}
	
	public static void main(String[] args) {
		System.out.print("Indica el SO (0|1): ");
		Scanner sc = new Scanner(System.in);
		System.out.print("\n");
		int SO = sc.nextInt();
		
		GUIFactory miFactoria = createOsSpecificFactory(SO);
		
		Application app = new Application(miFactoria);
	}		
}
