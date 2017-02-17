import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 
 * @author Alex Chiang <agentleader1@gmail.com>
 *
 */
public class Librarian {

	private static final String PROBLEM = "Librarian";
	private static final String EXT = ".dat";

	public static void main(String[] args) {
		Scanner scan;
		try {
			scan = new Scanner(new File(PROBLEM + EXT));
		} catch (FileNotFoundException ex) {
			printF(true, "File not found: %s", ex.getMessage());
			return;
		}
		int times = Integer.parseInt(scan.nextLine());
		while (times-- > 0) {
			TreeMap<String, String> books = new TreeMap<>();
			for (int b = 0; b < 10; b++) {
				String book = scan.nextLine();
				books.put(reverse(book), book);
			}
			for (String s : books.keySet()) {
				printLine(books.get(s));
			}
			printLine();
			if (times >= 1)
				scan.nextLine();
		}
		scan.close();
	}
	
	private static String reverse(String s) {
		return (new StringBuilder(s)).reverse().toString();
	}

	public static void print(Object... o) {
		for (Object obj : o) {
			System.out.print(obj);
		}
	}

	public static void printLine(Object... o) {
		if (o.length <= 0) {
			System.out.println();
			return;
		}
		for (Object obj : o) {
			System.out.println(obj);
		}
	}

	public static void printF(boolean newLine, String format, Object... o) {
		System.out.printf(format + ((newLine) ? "\n" : ""), o);
	}

}
