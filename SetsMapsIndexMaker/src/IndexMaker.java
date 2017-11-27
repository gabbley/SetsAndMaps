
/**
 * <h1>IndexMaker</h1>
 * <br/><br/>
 * @author not Gabby Baniqued, only partially
 *
 * This program takes a text file, creates an index (by line numbers)
 *  for all the words in the file and writes the index
 *  into the output file.  The program takes input and output file names
 *  from the command-line args or prompts the user for the file names.
 */
import java.util.TreeSet;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


public class IndexMaker {
	public static void main(String[] args) throws IOException {

		Scanner keyboard = new Scanner(System.in);
		String fileName;

		// Open input file:

		if (args.length > 0) // if file is provided as an argument
			fileName = args[0];
		else {
			System.out.print("\nEnter input file name: ");
			fileName = keyboard.nextLine().trim();
		}

		BufferedReader inputFile = // already throws a filenotfoundexception
				new BufferedReader(new FileReader(fileName), 1024);

		// Create output file:

		if (args.length > 1)
			fileName = args[1];
		else {
			System.out.print("\nEnter output file name: ");
			fileName = keyboard.nextLine().trim();
		}

		PrintWriter outputFile = new PrintWriter(new FileWriter(fileName));

		// Create index:

		DocumentIndex index = new DocumentIndex();

		String line;
		int lineNum = 0;
		while ((line = inputFile.readLine()) != null) {
			lineNum++;
			index.addAllWords(line, lineNum);
		}

		// Save index:
		// https://stackoverflow.com/questions/1318980/how-to-iterate-over-a-treemap

		Set<String> keys = index.keySet();
		for (String key : keys) {

			IndexEntry value = index.get(key);
			outputFile.println(value);
		}

		// Finish:

		inputFile.close();
		outputFile.close();

		keyboard.close();
		System.out.println("Done.");
	}


}
