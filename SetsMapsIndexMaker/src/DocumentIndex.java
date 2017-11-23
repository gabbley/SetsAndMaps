import java.util.TreeMap;

public class DocumentIndex extends TreeMap<String, IndexEntry> {

	private TreeMap<String, IndexEntry> list;

	public DocumentIndex() {
		super();
	}

	public void addWord(String word, int num) {
		word = word.toUpperCase();
		if (this.containsKey(word))
			this.get(word).add(num);
		else
			this.put(word, new IndexEntry(word, num));
	}

	public void addAllWords(String str, int num) {
		str = str.toUpperCase();
		String[] strArr = str.split("\\W+");
		for (String word : strArr) {
			if (!word.equals(""))
				addWord(word, num);
		}
	}

}
