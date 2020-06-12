package stateandbehavior;

public class UpOrDownCounter {
	private int start;
	private int end;
	private int counter;
	
	public UpOrDownCounter(int start, int end) {
		this.start = start;
		this.end = end;
		this.counter = start;
		if (start == end) {
			throw new IllegalArgumentException("start and end cannot be the same");
		}
	}
	
	public int getCounter() {
		return counter;
	}
	
	public boolean count() {
		if (counter != end) {
			return true;
		}
		else {
			return false;
		}
	}

}
