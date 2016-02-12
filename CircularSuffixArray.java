import java.util.ArrayList;
import java.util.Arrays;

public class CircularSuffixArray {

	private static Integer length; //length of the original string
	private static int[] index;
	public static String[] circularSuffixArray; //the data structure which contains the Circular Suffix Array
	
	public CircularSuffixArray(String s) { // circular suffix array of s
		length = s.length();
		circularSuffixArray = new String[length];
		
		circularSuffixArray[0] = s + 0;
		ArrayList<Character> a = newArrayList(s);
		
		//removes the first element of the ArrayList and appends it to the back
		//then casts the arraylist to a string and adds it to the circular suffix array.
		for(int i = 1; i < length; i++){
			a.add(a.remove(0));
			circularSuffixArray[i] = toString(a) +  i; //Adds the string representation of the array list to the suffix array, appended by its number in the original order
		}
		
		//sorts the circular suffix array.
		Arrays.sort(circularSuffixArray);
		
		//constructs the index
		index = new int[length];
		String indexString = "";
		for(int i = 0; i < length; i++){
			for(int j = length; j < circularSuffixArray[i].length(); j++){
				indexString = indexString + circularSuffixArray[i].charAt(j);
			}
			index[i] = Integer.parseInt(indexString);
			indexString = "";
		}
		
	}
		
	//Constructs an ArrayList with the same elements as a given string
	private ArrayList<Character> newArrayList(String s){
		ArrayList<Character> a = new ArrayList<Character>(length);
		for(int i = 0; i < length; i++){
			a.add(s.charAt(i));
		}
		return a;
	}
	
	//Converts an array list into a properly formatted string
	private String toString(ArrayList<Character> a){
		String s = "";
		for(int i = 0; i < length; i++){
			s = s + a.get(i);
		}
		return s;
	}

	public int length() { // length of s
		return length;
	}

	public int index(int i) { // returns index of ith sorted suffix
		return index[i];
	}

	public static void main(String[] args) { // unit testing (not graded)
		
	}
}
