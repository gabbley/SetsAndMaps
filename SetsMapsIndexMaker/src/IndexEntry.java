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
	}

	public void add(int num) {
		if (!numsList.contains(word))
			numsList.add(num);
	}

	public String getWord() {
		return word;
	}

	public String toString() {
		return getWord() + " " + numsList.toString();
	}

}
