/**
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
import java.util.Scanner;

public class IndexMaker
{
  public static void main(String[] args) throws IOException
  {
	  
    Scanner keyboard = new Scanner(System.in);
    String fileName;

    // Open input file:

    if (args.length > 0) //if file is provided as an argument
      fileName = args[0];
    else
    {
      System.out.print("\nEnter input file name: ");
      fileName = keyboard.nextLine().trim();
    }

    BufferedReader inputFile = //already throws a filenotfoundexception
                 new BufferedReader(new FileReader(fileName), 1024);
    

    // Create output file:

    if (args.length > 1)
      fileName = args[1];
    else
    {
      System.out.print("\nEnter output file name: ");
      fileName = keyboard.nextLine().trim();
    }

    PrintWriter outputFile =
                 new PrintWriter(new FileWriter(fileName));

    // Create index:

    DocumentIndex index = new DocumentIndex();

    String line;
    int lineNum = 0;
    while ((line = inputFile.readLine()) != null)
    {
      lineNum++;
      index.addAllWords(line, lineNum);
    }

    // Save index:

/*    while (index.)
     outputFile.println(entry);
    
    for(Map.Entry<String,Integer> entry : treeMap.entrySet()) {
    	  String key = entry.getKey();
    	  Integer value = entry.getValue();

    	  System.out.println(key + " => " + value);
    	}*/

    // Finish:

    inputFile.close();
    outputFile.close();

    keyboard.close();
    System.out.println("Done.");
  }
  
  //TODO check for non-existent input file
  //TODO existing output file
  //TODO empty input file
  //TODO input file blank lines
  //TODO input file with lines taht have leading spaces or punctuation
  //TODO input file with multiple occurrence of a word ont eh same line
  //TODO input file with the same word on diff lines
  //TODO input file of all the same word, multiple times, same line, mult lines
  
  
}
