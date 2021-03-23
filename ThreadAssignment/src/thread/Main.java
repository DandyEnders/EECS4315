package thread;

public class Main {

	public static void main(String[] args) {
		Printer printerMyNameIs = new Printer("My name is", 2);
		Printer printerJinho = new Printer("Jinho", 2);
		
		printerMyNameIs.start();
		printerJinho.start();
	}

}
