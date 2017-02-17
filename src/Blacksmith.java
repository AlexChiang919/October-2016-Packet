/**
 * 
 * @author Alex Chiang <agentleader1@gmail.com>
 *
 */
public class Blacksmith {

	public static void main(String[] args) {
		printLine("         &&&");
		printLine("         &");
		printLine("*######## & ---------------\\");
		printLine("*######## & ---------------/");
		printLine("         &");
		printLine("         &&&");
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
