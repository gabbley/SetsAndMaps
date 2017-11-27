import java.util.TreeSet;

/**
 * <h1>IndexEntry</h1> contains word and its corresponding line number(s)
 * <br/><br/>
 * @author Gabby Baniqued
 */

public class IndexEntry {

	/**
	 * String field - the current word
	 */
	public String word;
	
	/**
	 * TreeSet of Integers - contains line numbers for the current word
	 */
	public TreeSet<Integer> numsList;

	
	/**
	 * Default constructor: creates a new IndexEntry
	 * Sets current word to an empty String, 
	 * initializes numList
	 */
	public IndexEntry() {
		word = "";
		numsList = new TreeSet<Integer>();
	}

	/**
	 * Constructor: creates a new IndexEntry using a given word
	 * initializes numList
	 * 
	 *  @param word  creates new IndexEntry using this word
	 */
	public IndexEntry(String word) {
		this.word = word;
		numsList = new TreeSet<Integer>();
	}
	
	/**
	 * Constructor: creates a new IndexEntry using a given word and line number
	 * initializes numList
	 * 
	 *  @param word  creates new IndexEntry using this word
	 *  @param num  the word's corresponding line number
	 */
	public IndexEntry(String word, int num) {
		this.word = word;
		numsList = new TreeSet<Integer>();
		numsList.add(num);
	}

	/**
	 * Adds line number to numList
	 * 
	 *  @param num  line number to be added (if not contained already)
	 */
	public void add(int num) {
		if (!numsList.contains(num))
			numsList.add(num);
	}

	/**
	 * getter to get word field
	 * 
	 */
	public String getWord() {
		return word;
	}


	/**
	 * Overrides the default toString
	 * @return String of IndexEntry: shows word and corresponding line number
	 */
	@Override
	public String toString() {
		return (getWord() + " " + numsList.toString()).toUpperCase();
	}

}
