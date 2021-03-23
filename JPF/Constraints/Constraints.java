import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Constraints {
	public static void main(String[] args) {
		Random random = new Random();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; random.nextBoolean(); i++) {
			list.add(new Integer(i));
		}
	}
}
