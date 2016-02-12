import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {

	// apply Burrows-Wheeler transform, reading from standard input and writing
	// to standard output
	public static void transform() {
		String s = BinaryStdIn.readString();

		CircularSuffixArray transArray = new CircularSuffixArray(s);

		
		char[] transChars = new char[s.length()];
		for (int i = 0; i < transArray.length(); i++) {
			transChars[i] = CircularSuffixArray.circularSuffixArray[i].charAt(transArray.length() - 1);
		}
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			if (transArray.index(i) == 0) {
				index = i;
				break;
			}
		}

		BinaryStdOut.write(index); // needs to be written before the string
		String transString = new String(transChars);
		BinaryStdOut.write(transString);
		BinaryStdOut.flush(); // needed to flush
	}

	// apply Burrows-Wheeler inverse transform, reading from standard input and
	// writing to standard output
	public static void inverseTransform() {
		int originalIndex = BinaryStdIn.readInt();
		String wheelerString = BinaryStdIn.readString();

		// Sorts the wheelerString to produce the first column of the circular
		// suffix array
		char[] c = wheelerString.toCharArray();

		Arrays.sort(c);
		String sortedString = new String(c);

		// Constructs the next array, which is a recreation of the index array
		int[] next = new int[wheelerString.length()];

		// Fills in the next array. Uses a Hashmap to contain the positions of
		// characters.
		// Hashmap uses iterations of a character as a key, and an arraylist of
		// the int positions of those characters . The arraylist goes from Lower
		// -> Higher.
		HashMap<Character, ArrayList<Integer>> wheelerMap = new HashMap<Character, ArrayList<Integer>>();
		ArrayList<Integer> arrayPointer = null;

		for (int i = 0; i < wheelerString.length(); i++) {
			if (!wheelerMap.containsKey(wheelerString.charAt(i))) {
				arrayPointer = new ArrayList<Integer>();
				arrayPointer.add(i);
				wheelerMap.put(wheelerString.charAt(i), arrayPointer);
				arrayPointer = null;
			} else {
				arrayPointer = wheelerMap.get(wheelerString.charAt(i));
				for (int x = 0; x < arrayPointer.size(); x++)
					if (i < arrayPointer.get(x)) {
						arrayPointer.add(i, x);
						break;
					} else if (x == arrayPointer.size() - 1) {
						arrayPointer.add(i);
						break;
					}
				arrayPointer = null;
			}
		}

		// Fills in the next array using the hashmap's smallest value for a
		// given character.
		// Since we start at 0, the sorted character will also have the smallest
		// possible value.
		for (int i = 0; i < sortedString.length(); i++) {
			next[i] = wheelerMap.get(sortedString.charAt(i)).remove(0);
		}

		// Reconstructs the original string using the next array.
		char[] originalString = new char[sortedString.length()];
		originalString[0] = sortedString.charAt(originalIndex);
		originalString[sortedString.length()-1] = wheelerString.charAt(originalIndex);
		
		int x = originalIndex;
		for(int charIndex = 1; charIndex < wheelerString.length() - 1; charIndex++) {
			x = next[x];
			originalString[charIndex] = sortedString.charAt(x);
		}

		BinaryStdOut.write(new String(originalString));
		BinaryStdOut.flush();
	}

	// if args[0] is '-', apply Burrows-Wheeler transform
	// if args[0] is '+', apply Burrows-Wheeler inverse transform
	public static void main(String[] args) {
		if (args[0].equals("-")) // needed to use .equals instead of ==
			transform();
		else if (args[0].equals("+"))
			inverseTransform();
	}
}
