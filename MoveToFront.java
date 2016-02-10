import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {

	private static char[] ascii = new char[256];

	// apply move-to-front encoding, reading from standard input and writing to
	// standard output
	public static void encode() {
		while (!BinaryStdIn.isEmpty()) {
			char temp = BinaryStdIn.readChar();
			char[] newAscii = new char[256];
			int fix = 1; // to reserve first index
			newAscii[0] = temp; // move to front

			// get character index and move to front
			for (int i = 0; i < ascii.length; i++) {
				newAscii[i + fix] = ascii[i]; // reserve first index
				if (temp == ascii[i]) {
					BinaryStdOut.write(i, 8);
					// System.out.println(i);
					fix = 0;
				}
			}
			ascii = newAscii;
		}
		BinaryStdOut.flush();
		BinaryStdOut.close();
	}

	// apply move-to-front decoding, reading from standard input and writing to
	// standard output
	public static void decode() {

		while (!BinaryStdIn.isEmpty()) {
			char temp = BinaryStdIn.readChar(); // treat as int from 0-255
			char moveToFront = ascii[temp]; // char we need to move to ascii[0]
			BinaryStdOut.write(ascii[temp]);

			for (int i = temp; i > 0; i--) {
				ascii[i] = ascii[i - 1];
			}

			ascii[0] = moveToFront;
		}

		BinaryStdOut.flush();
	}

	// if args[0] is '-', apply move-to-front encoding
	// if args[0] is '+', apply move-to-front decoding
	public static void main(String[] args) {

		for (int i = 0; i < 256; i++) {
			ascii[i] = (char) i;
		}

		if (args[0].equals("-"))
			encode();
		else if (args[0].equals("+"))
			decode();

	}
}