import java.util.Arrays;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {
	
	// apply Burrows-Wheeler transform, reading from standard input and writing
	// to standard output
	public static void transform(){
		
		String s = BinaryStdIn.readString();
		//String s = "What in Davy Jones’ locker did ye just bark at me, ye scurvy bilgerat? I’ll have ye know I be the meanest cutthroat on the seven seas, and I’ve led numerous raids on fishing villages, and raped over 300 wenches. I be trained in hit-and-run pillaging and be the deadliest with a pistol of all the captains on the high seas. Ye be nothing to me but another source o’ swag. I’ll have yer guts for garters and keel haul ye like never been done before, hear me true. You think ye can hide behind your newfangled computing device? Think twice on that, scallywag. As we parley I be contacting my secret network o’ pirates across the sea and yer port is being tracked right now so ye better prepare for the typhoon, weevil. The kind o’ monsoon that’ll wipe ye off the map. You’re sharkbait, fool. I can sail anywhere, in any waters, and can kill ye in o’er seven hundred ways, and that be just with me hook and fist. Not only do I be top o’ the line with a cutlass, but I have an entire pirate fleet at my beck and call and I’ll damned sure use it all to wipe yer arse off o’ the world, ye dog. If only ye had had the foresight to know what devilish wrath your jibe was about to incur, ye might have belayed the comment. But ye couldn’t, ye didn’t, and now ye’ll pay the ultimate toll, you buffoon. I’ll shit fury all over ye and ye’ll drown in the depths o’ it. You’re fish food now.";
		
		CircularSuffixArray transArray = new CircularSuffixArray(s);
		
		String transString = "";
		for (int i = 0; i < transArray.length(); i++){
			transString = transString + CircularSuffixArray.circularSuffixArray[i].charAt(transArray.length()-1);
		}
		transString = transArray.index(0) + " " + transString;
		
		//System.out.println(transString);
		BinaryStdOut.write(transString);
	}

    // apply Burrows-Wheeler inverse transform, reading from standard input and writing to standard output
	public static void inverseTransform(){
		String wheelerString = BinaryStdIn.readString();
		
		String indexString = "";
		int i = 0;
		while(wheelerString.charAt(i) != ' '){
			indexString = indexString + wheelerString.charAt(i);
			i++;
		}
		//Index output by a Burrows-wheeler Transform
		int originalIndex = Integer.parseInt(indexString);
		
		//String output by a Burrows-wheeler Transform, minus the index
		wheelerString = wheelerString.substring(i);
		
		//Sorts the wheelerString to produce the first column of the circular suffix array
		char[] c = wheelerString.toCharArray();
		Arrays.sort(c);
		String sortedString = new String(c);
		
		//Constructs the next array, which is a recreation of the index array from BWT
		int[] next = new int[wheelerString.length()];
		
		//Fills in the next array
		//TODO
		
		//Reconstructs the original string using the next array.
		String originalString = "" + sortedString.charAt(originalIndex);
		int x = originalIndex;
		while(originalString.length() < wheelerString.length() - 1){
			x = next[x];
			originalString = originalString + sortedString.charAt(x);
		}
		originalString = originalString + wheelerString.charAt(originalIndex);
		
		BinaryStdOut.write(originalString);
	}

    // if args[0] is '-', apply Burrows-Wheeler transform
    // if args[0] is '+', apply Burrows-Wheeler inverse transform
	public static void main(String[] args){
		//if(args[0] == "-")
			transform();
		/*else if(args[0] == "+")
			inverseTransform();
		else
			transform();*/
	}
}
