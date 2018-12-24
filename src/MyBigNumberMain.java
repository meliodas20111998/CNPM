import java.util.Scanner;
/**
 *  Hàm Main
 * @author Nguyễn Văn Quay
 *
 */

public class MyBigNumberMain implements IReceiver {
	/**
	 * Main function, take number strings from input
	 * Example: sum(59,21);
	 */
	
	public static void main(String [] args) {
	
		
		
		Scanner sc = new Scanner(System.in);
		MyBigNumberMain main = new MyBigNumberMain();
		MyBigNumber s = new MyBigNumber(main);
		
		try {
			
			String result = s.sum(args[0], args[1]);
			System.out.println("Result: "+ result + "\n");
			
		} catch (ExNumberFormatException e) {
			System.out.println("\n" + e.getMessage() + "\n");
		} catch(NumberFormatException e ) {
			System.out.println ("\n" + e.getMessage() + "\n");
		}

			sc.close();
	}
	 public void sendMessage(String str) {
	        System.out.println(str);
	    }
}
	
	
	  


