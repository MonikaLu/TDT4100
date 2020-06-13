package patterns.delegation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HighscoreList implements HighscoreListListener{
	
	private List<Integer> highscoreList = new ArrayList<Integer>();

	private int maxSize;
	
	public HighscoreList(int maxSize) {
		this.maxSize = maxSize;
//		List<Integer> highscoreList = new ArrayList<>(maxSize);
	}
	
	public int size() {
		return highscoreList.size();
	}
	
	public int getElement(int pos) {
		return highscoreList.get(pos);
	}
	
	public void addElement(int pos, int element) {
		if (pos < maxSize) {
			while (size() >= maxSize) {
				highscoreList.remove((size() - 1));
			}
			highscoreList.add(pos, element);
			fireListChanged(pos);
		}
	}

	
	public void addResult(Integer result) {
		int pos = 0;
		while (pos < size() && result >= (int) highscoreList.get(pos)) {
			pos++;
		}
		addElement(pos, result);
	}

	
	private Collection<HighscoreListListener> listListeners = new ArrayList<HighscoreListListener>();
	public void addHighscoreListListener(HighscoreListListener listListener) {
		if (! listListeners.contains(listListener)) {
			listListeners.add(listListener);
		}
	}
	
	public void removeHighscoreListListener(HighscoreListListener listListener) {
		listListeners.remove(listListener);
	}
	
	protected void fireListChanged(int pos) {
		for (HighscoreListListener listListener : listListeners) {
			listListener.listChanged(this, pos);
		}
	}


	@Override
	public void listChanged(HighscoreList list, int i) {
		// TODO Auto-generated method stub
		
	}}
