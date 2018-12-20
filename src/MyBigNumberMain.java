import java.util.Scanner;

public class MyBigNumberMain {
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		MyBigNumberMain main = new MyBigNumberMain();
		MyBigNumber s = new MyBigNumber();
		System.out.print(" Nhap so thu 1: ");
		String s1 = sc.nextLine();
		
		System.out.print(" Nhap so thu 2: ");
		String s2 = sc.nextLine();
		
		String result = s.sum(s1, s2);
		
		System.out.println("Result: " + result +"\n");
		
	}

}
