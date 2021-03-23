import java.util.Random;

public class StateSpace {
	public static void main (String [] args){
		Random random = new Random();
		System.out.print("0 ");
		if (!random.nextBoolean()){
			System.out.print("1 ");
			if(!random.nextBoolean()){
				System.out.print("3 ");		
			} else {
				System.out.print("4 ");	
				if(!random.nextBoolean()){
					System.out.print("5 ");	
				} else {
					System.out.print("6 ");	
				}
			}
		} else {
			System.out.print("2 ");	
		}
	}
}
