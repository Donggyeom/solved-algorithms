import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		long A = Long.parseLong(input[0]);
		long B = Long.parseLong(input[1]);
		long C = Long.parseLong(input[2]);
		
		long answer = pow(A, B, C);
		
		System.out.println(answer);
	}
	
	static long pow(long a, long e, long C) {

		if (e == 1) {
			return a % C;
		}
		
		long temp = pow(a, e / 2, C) % C;
		
		if (e % 2 == 1) {
			return (((temp * temp) % C) * a) % C;
		}
		
		return (temp * temp) % C;
	}
}

/**
  * 1629. 곱셈
  * 
**/