import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Arrays;



public class Main {
	
	public static String[] rqs = {
        "EVEN",
		"ODD",
		"BUZZ",
		"DUCK",
		"PALINDROMIC",
		"GAPFUL",
		"SPY"};
		
	public static NumberFormat format = NumberFormat.getInstance(new Locale("en", "US"));
		
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Amazing Numbers!\n\nSupported requests:");
		System.out.println("- enter a natural number to know its properties;\n- enter two natural numbers to obtain the properties of the list:");
		System.out.println("  * the first parameter represents a starting number;");
		System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;\n- two natural numbers and a property to search for;");
		System.out.println("- separate the parameters with one space;\n- enter 0 to exit.");
		
		long num = 1;
		while (num != 0) {
			System.out.print("\nEnter a request: ");
			String[] request = sc.nextLine().split(" ");
			num = Long.parseLong(request[0]);
			int lnRequest = request.length;
			boolean errFlag = true;
			System.out.println();
			if (Long.parseLong(request[0]) < 0 || Long.parseLong(request[0]) == 0) {
				errFlag = false;
				System.out.print("The first parameter should be a natural number or zero.");
			}
			if (lnRequest > 1 && errFlag) {
				if (Long.parseLong(request[1]) <= 0) {
					errFlag = false;
					System.out.println("The second parameter should be a natural number.");
				}
			}
			if (lnRequest > 2 && errFlag) {
				boolean fl = false;
				for (String s : rqs) {
					if (s.equalsIgnoreCase(request[2])) {
						fl = true;
						break;
					}
				}
				if (!fl) {
					System.out.print("The property [" + request[2].toUpperCase() + "] is wrong.");
					System.out.print("Available properties " + Arrays.toString(rqs));
					errFlag = false;
				}
				
			}
			if (errFlag) {
				switch(lnRequest) {
				case 1: oneNum(Long.parseLong(request[0])); break;
				case 2: rangeOfNum(Long.parseLong(request[0]), Long.parseLong(request[1])); break;
				case 3: propertyNums(Long.parseLong(request[0]), Long.parseLong(request[1]), request[2]); break;
				}
			}
			
		}
		System.out.println("\nGoodbye!");
	
	}
	
		public static boolean isEven(long number) {
			if (number % 2 == 0) {
				return true;
			} else {
				return false;
			}
		}
		
		public static boolean isOdd(long number) {
			if (number % 2 == 0) {
				return false;
			} else {
				return true;
			}
		}
		
		public static boolean isBuzz(long number) {
			if (number % 10 == 7) {
				return true;
			} else if (number % 7 == 0) {
				return true;
			} else {
				return false;
			}
		
		}
		
		public static boolean isDuck(long number) {
			while(number > 0) {
				if (number % 10 == 0) {
					return true;
				}
				number = number / 10;
				}
			return false;
		}
		
		public static boolean  isPalindrom(long number) {
			String numString = Long.toString(number);
			String revString = new StringBuilder(numString).reverse().toString();
			if (numString.equals(revString)) {
				return true;
			} else {
				return false;
			}
		}
		
		public static boolean  isGapful(long number) {
			String[] numArray = Long.toString(number).split("");
			if (numArray.length <= 2) {
				return false;
			}
			if (number % Long.parseLong(String.valueOf(numArray[0] + numArray[numArray.length - 1])) == 0) {
				return true;
			} else {
				return false;
			}
		}
		
		public static boolean isSpy (long number) {
			String[] strNum = Long.toString(number).split("");
			long product = 1;
			long sum = 0;
			for(String n : strNum) {
				product *= Long.parseLong(n);
				sum += Long.parseLong(n);
			}
			return (product == sum) ? true : false;
		}
		
		public static boolean isSquare(long number) {
			double square = Math.sqrt(number);
			boolean result = (square - (long) square != 0) ? false: true;
			return result;
		}
		
		public static boolean isSunny(long number) {
			boolean result = isSquare(number + 1);
			return result;
		}
		
		
		public static void oneNum (long number) {
			System.out.println("Properties of " + format.format(number));
			System.out.println(String.format("        buzz: %b", isBuzz(number)));
			System.out.println(String.format("        duck: %b", isDuck(number)));
			System.out.println(String.format(" palindromic: %b", isPalindrom(number)));
			System.out.println(String.format("      gapful: %b", isGapful(number)));
			System.out.println(String.format("         spy: %b", isSpy(number)));
			System.out.println(String.format("        even: %b", isEven(number)));
			System.out.println(String.format("         odd: %b", isOdd(number)));
		}
		
		public static void rangeOfNum (long num, long j) {
			if (j <= 0 ) {
                System.out.println("The second parameter should be a natural number");
				return;
            }
			for(int i = 0; i < j; i++) {
				long number = num + i ;
				System.out.println(builder(number));
			}
			
			return;	
		}
		
		public static void propertyNums(long number, long j, String property) {
			property = property.toUpperCase();
			int i = 0;
			while (i != j){
				switch (property) {
					case("EVEN") : 
						if (isEven(number)) {
							System.out.println(builder(number));	
							i++;
						} 
						number++;
						break;
					case("ODD") : 
						if (isOdd(number)) {
							System.out.println(builder(number));	
							i++;
						} 
						number++;
						break;
					case("BUZZ") : 
						if (isBuzz(number)) {
							System.out.println(builder(number));	
							i++;
						} 
						number++;
						break;
					case("DUCK") : 
						if (isDuck(number)) {
							System.out.println(builder(number));	
							i++;
						} 
						number++;
						break;
					case("PALINDROMIC") : 
						if (isPalindrom(number)) {
							System.out.println(builder(number));	
							i++;
						} 
						number++;
						break;
					case("GAPFUL") : 
						if (isGapful(number)) {
							System.out.println(builder(number));	
							i++;
						}
						number++;
						break;
					case("SPY") : 
						if (isSpy(number)) {
							System.out.println(builder(number));	
							i++;
						} 
						number++;
						break;
				}
			}
		}
		
		public static String builder(long number) {
			String results = format.format(number) + " is ";
			results += isBuzz(number) ? "buzz, " : "";
			results += isDuck(number) ? "duck, " : "";
			results += isPalindrom(number) ? "palindromic, " : "";
			results += isGapful(number) ? "gapful, " : "";
			results += isSpy(number) ? "spy, " : "";
			results += isEven(number) ? "even" : "";
			results += isOdd(number) ? "odd" : "";
			return results;
				
		}
}

