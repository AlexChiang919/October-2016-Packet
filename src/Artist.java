import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Alex Chiang <agentleader1@gmail.com>
 *
 */
public class Artist {

	private static final String PROBLEM = "artist";
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
			x = y = 0;
			String[] split = scan.nextLine().split(" ");
			int r = Integer.parseInt(split[0]);
			int c = Integer.parseInt(split[1]);
			char[][] ch = new char[r][c];
			fill(ch, '.');
			String[] cmd = scan.nextLine().split(" ");
			for (String s : cmd) {
				go(ch, parseDirection(s), Integer.parseInt(s.substring(2)) - 1);
			}
			printArray(ch);
			printLine();
		}
		scan.close();
	}
	
	private static void fill(char[][] ch, char c) {
		for (int r = 0; r < ch.length; r++) {
			for (int b = 0; b < ch[r].length; b++) {
				ch[r][b] = c;
			}
		}
	}
	
	private static int parseDirection(String s) {
		char c = s.charAt(0);
		if (c == 'D')
			return 1;
		if (c == 'R')
			return 2;
		if (c == 'L')
			return 3;
		if (c == 'U')
			return 4;
		return 0;
	}
	
	private static int x = 0;
	private static int y = 0;
	/*
	 * D = 1
	 * R = 2
	 * L = 3
	 * U = 4
	 */
	public static void go(char[][] c, int direction, int mag) {
		if (inBounds(c, x, y)) {
			c[x][y] = '#';
		}
		if (mag < 0)
			return;
		if (direction == 1)
			x++;
		else if (direction == 2)
			y++;
		else if (direction == 3)
			y--;
		else if (direction == 4)
			x--;
		if (inBounds(c, x, y)) {
			c[x][y] = '#';
			go(c, direction, --mag);
		}
	}
	
	public static boolean inBounds(char[][] ch, int r, int c) {
		return (0 <= r && r < ch.length) && (0 <= c && c < ch[r].length);
	}
	
	public static void printArray(char[][] ch) {
		for (char[] r : ch) {
			for (char c : r) {
				print(c);
			}
			printLine();
		}
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
