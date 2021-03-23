
public class Main {

	public static void main(String[] args) {
		Printer printerMyNameIs = new Printer(2);
		Printer printerJinho = new Printer(2);
		
		Thread threadMyNameIs = new Thread(printerMyNameIs, "My name is ");
		Thread threadJinho = new Thread(printerJinho, "Jinho");

		threadMyNameIs.start();
		threadJinho.start();

	}

}
