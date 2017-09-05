import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class main {

	static String[] charcters = {"a", "b", "c", "d", "e", "f", "g", "H", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	static String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
	static String[] symbols = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "+", ".", ":", ";", "<", "=", ">", "?", "^", "~" };

	public static int randomInt(int min, int max) { //generates a random integer between the two parameters
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	static String randKey(int num, int symb) {
		ArrayList<String> id = new ArrayList<String>();
		String key = "";
		int options = 0;
		for (int i = 0; i < num ; i++) {
			int type = randomInt(0, symb);
			if (type == 0) {
				id.add(charcters[randomInt(0, 25)]);
				options++;
			} else if (type == 1) {
				id.add(numbers[randomInt(0, 8)]);
				options++;
			} else if (type == 2) {
				id.add(symbols[randomInt(0, 19)]);
				options++;
			}
			if (num != 4 && options % 4 == 0 && options != num && num % 4 == 0 ) {
				id.add("-");
			}
		}
		for (String i : id) {
			key += i;
		}
		return key;
		// Add feature which checks whether key has been displayed before
	}
	
	static boolean symbols() {
		boolean repeatMethod = true;
		boolean symbols = false;
		String s;
		do {
			Scanner sym = new Scanner(System.in);
			System.out.println("Would you like symbols in your keys?");
			s = sym.nextLine();
			s.toLowerCase();
			if (s.equals ("no") || s.equals("yes")) {
				repeatMethod = false;
				if (s.equals("no")) {
					symbols = false;
				} if (s.equals("yes")) {
					symbols = true;
				}
			} else {
				System.out.println("Please answer 'yes' or 'no'");
			}
		}while (repeatMethod) ;
		return symbols;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean program = true;
		do {
			Scanner info = new Scanner(System.in); 
			System.out.println("How many keys would you like? ");
			int n = info.nextInt();
			String[] keys = new String[n];
			System.out.println("How many characters in each key?");
			int c = info.nextInt();
			if (symbols()) {
				for (int i = 0 ; i < n ; i++) {
					keys[i] = randKey(c, 2);
					System.out.println(keys[i]);
				}
			} else {
				for (int i = 0 ; i < n ; i++) {
					keys[i] = randKey(c, 1);
					System.out.println(keys[i]);
				}
			} 
			boolean repeat = true;
			do {
				Scanner rep = new Scanner(System.in);
				System.out.println("Would you like to make more keys?");
				String a = rep.nextLine();
				a.toLowerCase();
				if (a.equals("yes")) {
					repeat = false;
				}
				else if (a.equals("no")) {
					repeat = false;
					program = false;
				} else {}
			} while (repeat);

		} while (program);



	}

}
