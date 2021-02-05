/**
 * @author Mulualem Hailom
 * @assignment CSC212-Lab10
 * @version (5/3/2019)
 * 
 * This program reads a text file, replaces 4-letter 
 * words with "****", and prints an alphabetical list of the 
 * replaced words.
 */
import java.util.*;
import java.io.*;

public class Bleep {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("hamlet.txt"));

		ArrayList<String> list = getWords(input);

		ArrayList<String> bleepedWords = replace4LetterWords(list);

		System.out.println("The edited list:  " + list);

		Collections.sort(bleepedWords);
		removeDuplicates(bleepedWords);

		System.out.println("\nList of bleeped words:");
		for (String word : bleepedWords) {
			System.out.println("\t" + word);
		}

		// removeInRange(bleepedWords, "final", "rich");

		System.out.println("\nList of bleeped words after range removal:");
		for (String word : bleepedWords) {
			System.out.println("\t" + word);
		}
	}

	//takes in a file of text and returns ArrayList contains list of words
	public static ArrayList<String> getWords(Scanner input){
		input.useDelimiter("[^a-zA-Z']+");
		ArrayList<String> allWords = new ArrayList<String>();
		//		Scanner input = new Scanner(new File("hamlet.txt"));
		while(input.hasNext()) {
			String word = input.next().toLowerCase();
			allWords.add(word);

		}

		return allWords;

	}

	//takes in an array list of words and return an array list of words of four letters.
	public static ArrayList<String> replace4LetterWords (ArrayList<String> words){
		ArrayList<String> fourLetter = new ArrayList<String>();
		for(int i=0; i<words.size(); i++) {
			if(words.get(i).length() == 4) {
				String replacement = words.get(i);
				words.set(i, "****");
				fourLetter.add(replacement);
			}
		}
		return fourLetter;

	}

	// takes in an array list contains words and returns an array list with our repetition of words. 
	public static void removeDuplicates(ArrayList<String> fourLetter ) {
		for(int i=fourLetter.size()-1; i>0; i--) {
			if(fourLetter.get(i).equals(fourLetter.get(i-1))) {
				fourLetter.remove(i-1);
			}
		}
	}

}
