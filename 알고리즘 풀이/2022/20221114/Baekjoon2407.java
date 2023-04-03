import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		m = m > (n-m) ? (n-m) : m;
		
		BigDecimal bigNumber = new BigDecimal("1");
		for (int i = 0; i < m; i++) {
			bigNumber = bigNumber.multiply(new BigDecimal(Integer.toString(n - i)));
			bigNumber = bigNumber.divide(new BigDecimal(Integer.toString(m - i)), 50, RoundingMode.HALF_UP);
		}
		
		System.out.println(bigNumber.setScale(0, RoundingMode.HALF_UP).toBigIntegerExact().toString());
	}	
}

/**
  * 2407. 조합
  * 
**/