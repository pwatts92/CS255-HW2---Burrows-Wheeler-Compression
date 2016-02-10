import java.util.ArrayList;
import java.util.Arrays;

public class CircularSuffixArray {

	private static Integer length; //length of the original string
	private Integer[] index;
	public static String[] circularSuffixArray; //the data structure which contains the Circular Suffix Array
	
	public CircularSuffixArray(String s) { // circular suffix array of s
		length = s.length();
		circularSuffixArray = new String[length];
		
		circularSuffixArray[0] = s;
		ArrayList<Character> a = newArrayList(s);
		
		//removes the first element of the ArrayList and appends it to the back
		//then casts the arraylist to a string and adds it to the circular suffix array.
		for(int i = 1; i < length; i++){
			a.add(a.remove(0));
			circularSuffixArray[i] = toString(a);
		}
		
		//sorts the circular suffix array.
		Arrays.sort(circularSuffixArray);
		
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
		new CircularSuffixArray("ABRACADABRA!");
		for(int i = 0; i < length; i++){
			System.out.println(circularSuffixArray[i]);
		}
	}
}
