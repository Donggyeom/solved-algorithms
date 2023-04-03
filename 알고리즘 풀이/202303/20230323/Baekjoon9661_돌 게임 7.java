import java.io.*;
import java.util.*;


class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		if (N % 5 == 0 || (N-2) % 5 == 0)
			System.out.println("CY");
		else {
			System.out.println("SK");
		}
	}
}

/**
 *	9661. 돌 게임 7 
 */