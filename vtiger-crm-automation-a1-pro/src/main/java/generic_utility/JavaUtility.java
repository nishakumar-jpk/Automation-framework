package generic_utility;


public class JavaUtility {
	public static int generateRandomNumber() {
		
		double randomDouble = Math.random();
		double ran = randomDouble*1000; 
		int random = (int) ran;
		return random;
		
	}
	

}
