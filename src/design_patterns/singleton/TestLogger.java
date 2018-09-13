package design_patterns.singleton;

public class TestLogger {

	public static void main(String[] args) {
		Logger log1 = Logger.getInstance();
		Logger log2 = Logger.getInstance();
		
		// Both objects have the same hash code
		System.out.println(log1.hashCode());
		System.out.println(log2.hashCode());
	}

}
