package t202109;

import java.util.Scanner;

public class t3 {
	static long next = 1;
	static int myrand() {
	    next = next * 1103515245 + 12345;
	    return (int)((Long.divideUnsigned(next, 65536)) % 32768);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
	}
}
