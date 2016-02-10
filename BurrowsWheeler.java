import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.StdOut;

public class BurrowsWheeler {
	
	// apply Burrows-Wheeler transform, reading from standard input and writing
	// to standard output
	public static void transform(){
		
		String s = BinaryStdIn.readString();
		CircularSuffixArray transArray = new CircularSuffixArray(s);
		
		String transString = "";
		for (int i = 0; i < transArray.length(); i++){
			transString = transString + CircularSuffixArray.circularSuffixArray[i].charAt(transArray.length()-1);
		}
		System.out.println(transString);
		BinaryStdOut.write(transString);
	}

    // apply Burrows-Wheeler inverse transform, reading from standard input and writing to standard output
	public static void inverseTransform(){
		
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
