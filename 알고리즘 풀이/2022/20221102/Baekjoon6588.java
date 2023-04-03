import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = -1;
		// 에라토스테네스의 체
		boolean[] bCompositeNumber = new boolean[1000001];
		for (int j = 2; j <= 1000; j++) {
			if (bCompositeNumber[j] != true) {
				for (int k = j*2; k <= 1000000; k = k+j) {
					bCompositeNumber[k] = true;
				}	
			}
		}
		LOOP_TC:
			while ((n = Integer.parseInt(br.readLine())) != 0 ) {				
				for (int j = 2; j <= n/2; j++) {
					if (bCompositeNumber[j] == false && bCompositeNumber[n-j] == false) {
						System.out.println(n + " = " + j + " + " + (n-j));
						continue LOOP_TC;
					}
				}
				System.out.println("Goldbach's conjecture is wrong.");
			}
	}
}

/**
  * 6588. 골드바흐의 추측
  * 
**/