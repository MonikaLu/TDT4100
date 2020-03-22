package stateandbehavior;

public class Location {
	
	private int x;
	private int y;
	
	public void up() {
		y -= 1;
	}
	
	public void down() {
		y += 1;
	}
	
	public void left() {
		x -= 1;
	}
	
	public void right() {
		x += 1;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		String ln1 = "The x-position is " + x;
		String ln2 = "\nThe y-position is " + y;
		return ln1 + ln2;
	}
	
	public static void main(String[] args) {
		Location test1 = new Location();
		test1.getX();
		test1.getY();
		System.out.println(test1);
	}
	
}
