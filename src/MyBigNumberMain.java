import java.util.Scanner;

public class MyBigNumberMain implements IReceiver {
	
	
	public static void main(String [] args) {
		
		boolean successfull = false;
		
		Scanner sc = new Scanner(System.in);
		MyBigNumberMain main = new MyBigNumberMain();
		MyBigNumber s = new MyBigNumber(main);
		
		System.out.println("Chao mung ban den voi phan mem cong 2 so !!! \n");
		while(!successfull) {
			try {
				String input = sc.nextLine();
				
				String[]split = input.split(" ");
				
				String Result = s.sum(split[1], split[2]);
				System.out.println("Result: " + Result +"\n" ); 	 	
				
				successfull = true;
				
			} catch (NumberFormatException e ) {
				System.out.println ("\n" + e.getMessage()+ "\n");
				
			}
		}
			sc.close();
	}
	 public void sendMessage(String str) {
	        System.out.println(str);
	    }
}
	
	
	  


