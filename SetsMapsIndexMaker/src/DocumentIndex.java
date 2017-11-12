import java.util.TreeMap;

public class DocumentIndex extends TreeMap<String, IndexEntry> {

	private TreeMap<String, IndexEntry> list;

	public DocumentIndex() {
		super();
	}

	public void addWord(String word, int num) {
		if (this.containsKey(word))
			this.get(word).add(num);
		else
			this.put(word, new IndexEntry(word));
	}

	public void addAllWords(String str, int num) {
		String[] strArr = str.split("\\W+");
		for (String word : strArr) {
			if (!word.equals(""))
				addWord(word, num);
		}
	}

}
