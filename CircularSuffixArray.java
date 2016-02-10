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
		//Test Case
		new CircularSuffixArray("What in Davy Jones’ locker did ye just bark at me, ye scurvy bilgerat? I’ll have ye know I be the meanest cutthroat on the seven seas, and I’ve led numerous raids on fishing villages, and raped over 300 wenches. I be trained in hit-and-run pillaging and be the deadliest with a pistol of all the captains on the high seas. Ye be nothing to me but another source o’ swag. I’ll have yer guts for garters and keel haul ye like never been done before, hear me true. You think ye can hide behind your newfangled computing device? Think twice on that, scallywag. As we parley I be contacting my secret network o’ pirates across the sea and yer port is being tracked right now so ye better prepare for the typhoon, weevil. The kind o’ monsoon that’ll wipe ye off the map. You’re sharkbait, fool. I can sail anywhere, in any waters, and can kill ye in o’er seven hundred ways, and that be just with me hook and fist. Not only do I be top o’ the line with a cutlass, but I have an entire pirate fleet at my beck and call and I’ll damned sure use it all to wipe yer arse off o’ the world, ye dog. If only ye had had the foresight to know what devilish wrath your jibe was about to incur, ye might have belayed the comment. But ye couldn’t, ye didn’t, and now ye’ll pay the ultimate toll, you buffoon. I’ll shit fury all over ye and ye’ll drown in the depths o’ it. You’re fish food now.");
		for(int i = 0; i < length; i++){
			System.out.println(index[i]);
		}
	}
}
