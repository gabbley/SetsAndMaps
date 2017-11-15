import java.util.TreeSet;

public class IndexEntry {

	public String word;
	public TreeSet<Integer> numsList;

	public IndexEntry() {
		word = "";
		numsList = new TreeSet<Integer>();
	}

	public IndexEntry(String word) {
		this.word = word;
		numsList = new TreeSet<Integer>();
	}
	
	public IndexEntry(String word, int num) {
		this.word = word;
		numsList = new TreeSet<Integer>();
		numsList.add(num);
	}

	public void add(int num) {
		if (!numsList.contains(num))
			numsList.add(num);
	}

	public String getWord() {
		return word;
	}

	public String toString() {
		return (getWord() + " " + numsList.toString()).toUpperCase();
	}

}
