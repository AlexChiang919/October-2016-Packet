import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Alex Chiang <agentleader1@gmail.com>
 *
 */
public class Banker {

	private static final String PROBLEM = "Banker";
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
			double bank = 0.0D;
			int m = Integer.parseInt(scan.nextLine());
			while (m-- > 0) {
				String s = scan.nextLine();
				double price = 0D;
				if (s.startsWith("+"))
					price = Double.parseDouble(s.substring(1));
				else
					price = Double.parseDouble(s);
				bank += price;
			}
			printF(true, "$%.2f", bank);
		}
		scan.close();
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
