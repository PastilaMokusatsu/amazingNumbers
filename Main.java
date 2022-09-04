import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Arrays;



public class Main {	
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
			System.out.println();
			checkAndRun(request);
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
			System.out.println(String.format("      square: %b", isSquare(number)));
			System.out.println(String.format("       sunny: %b", isSunny(number)));
			System.out.println(String.format("        even: %b", isEven(number)));
			System.out.println(String.format("         odd: %b", isOdd(number)));
		}
		
		public static void rangeOfNum (long num, long j) {
			for(int i = 0; i < j; i++) {
				long number = num + i ;
				System.out.println(builder(number));
			}
			
			return;	
		}
		
		public static void propertyNums(long number, long j, String[] properties) {
			int i = 0;
			while (i < j) {
				int counter = 0;
				String tmp = builder(number);
				for (String s : properties){
					if (tmp.contains(s.toLowerCase())) {
						counter++;
					}
				}
				if (counter == properties.length) {
					i++;
					System.out.println(tmp);
				}
				number++;
			}
		}
		
		public static void checkAndRun(String[] arrRequest) {
			int lnRequast = arrRequest.length;
			switch(lnRequast) {
				case 1: 
					 if(firstParamCheck(arrRequest[0])){
						 oneNum(Long.parseLong(arrRequest[0]));
					 }
					break;
				case 2: 
					if(firstParamCheck(arrRequest[0]) && secondParameterCheck(arrRequest[1])){
						rangeOfNum(Long.parseLong(arrRequest[0]), Long.parseLong(arrRequest[1]));
					 }
					break;
				case 3:
					String[] param =  Arrays.copyOfRange(arrRequest, 2, arrRequest.length);
					if(firstParamCheck(arrRequest[0]) && secondParameterCheck(arrRequest[1]) && propertyCheck(param)){
						propertyNums(Long.parseLong(arrRequest[0]), Long.parseLong(arrRequest[1]), param);
					 }
					break;
				case 4: 
					String[] param1 =  Arrays.copyOfRange(arrRequest, 2, arrRequest.length);
					if(firstParamCheck(arrRequest[0]) && secondParameterCheck(arrRequest[1]) && propertyCheck(param1) && aLotPropertyCheck(param1)){
						propertyNums(Long.parseLong(arrRequest[0]), Long.parseLong(arrRequest[1]), param1);
					 }
					break;
			}
		}
		
		public static boolean firstParamCheck(String param) {
			if (Long.parseLong(param) < 0 || Long.parseLong(param) == 0) {
				System.out.println("The first parameter should be a natural number or zero.");
				return false;
			}
			return true;
		}
		
		public static boolean secondParameterCheck(String param) {
			if (Long.parseLong(param) <= 0) {
				System.out.println("The second parameter should be a natural number.");
				return false;
			}
			return true;
		}
		
		public static boolean propertyCheck(String[] param) {
			int counter = 0;
			String[] rqs = {"EVEN", "ODD", "BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY"};
			for (String s : param) {
				s = s.toUpperCase();
				for ( String t : rqs) {
					if(s.equals(t)) {
						counter++;
						break;
					}
				}
			}
			if (counter == param.length) {
				return true;
			}
			System.out.println("The property " + Arrays.toString(param) + " is wrong.");
			System.out.println("Available properties " + Arrays.toString(rqs));
			return false;
			
		}
		
		public static boolean aLotPropertyCheck(String[] param) {
			String[][] rqs = {{"EVEN", "ODD"}, {"DUCK", "SPY"}, {"SQUARE", "SUNNY"}};
			param[0] = param[0].toUpperCase();
			param[1] = param[1].toUpperCase();
			for (String[] s : rqs) {
				if (s[0].equals(param[0]) && s[1].equals(param[1]) || (s[0].equals(param[1]) && s[1].equals(param[0]))) {
					System.out.println("The request contains mutually exclusive properties: " + Arrays.toString(param));
					System.out.println("There are no numbers with these properties.");
					return false;
				}
			}
			return true;
		}
		
		public static String builder(long number) {
			String results = format.format(number) + " is ";
			results += isBuzz(number) ? "buzz, " : "";
			results += isDuck(number) ? "duck, " : "";
			results += isPalindrom(number) ? "palindromic, " : "";
			results += isGapful(number) ? "gapful, " : "";
			results += isSpy(number) ? "spy, " : "";
			results += isSquare(number) ? "square, " : "";
			results += isSunny(number) ? "sunny, " : "";
			results += isEven(number) ? "even" : "";
			results += isOdd(number) ? "odd" : "";
			return results;
				
		}
}

