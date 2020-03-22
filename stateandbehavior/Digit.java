package stateandbehavior;

public class Digit {
	
	private int system;
	private int siffer;
	
	public Digit(int system) {
		this.system = system;
		siffer = 0;
	}
	
	public int getValue() {
		return siffer;
	}
	
	public boolean increment() {
		siffer++;
		if (siffer == system) {
			siffer = 0;
			return true;
		}
		return false;
	}
	
	public boolean isValid() {
		if (system > 0) {
			return true;
		}
		return false;
	}
	
	public int getBase() {
		return system;
	}
	
	@Override
	public String toString() {
		String[] liste = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		if (siffer > 9) {
			return liste[siffer-10];
		}
		return String.valueOf(siffer);
	}
	
	public static void main(String[] args) {
		Digit test1 = new Digit(36);
		for (int x = 0; x < 35; x++) {
			test1.increment();
			System.out.println(test1);
		}
	}
}
	
