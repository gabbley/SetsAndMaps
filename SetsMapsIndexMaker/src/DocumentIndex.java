import java.util.TreeMap;

/**
 * <h1>DocumentIndex</h1> a TreeMap of IndexEntry objects
 * <br/><br/>
 * @author Gabby Baniqued
 */

public class DocumentIndex extends TreeMap<String, IndexEntry> {

	private TreeMap<String, IndexEntry> list;

	/**
	 * Default constructor: creates empty TreeMap for IndexEntry objects.
	 */
	public DocumentIndex() {
		super();
	}
	
	/**
	 * Identifies line number to be added to IndexEntry based on given word.
	 * @param word  given word
	 * @param num  line number of word to be added
	 */
	public void addWord(String word, int num) {
		word = word.toUpperCase();
		if (this.containsKey(word))
			this.get(word).add(num);
		else
			this.put(word, new IndexEntry(word, num));
	}

	/**
	 * Splits String into individual words: adds line numbers accordingly.
	 * @param str  String of words
	 * @param num  line number of word(s) to be added
	 */
	public void addAllWords(String str, int num) {
		str = str.toUpperCase();
		String[] strArr = str.split("\\W+");
		for (String word : strArr) {
			if (!word.equals(""))
				addWord(word, num);
		}
	}

}
