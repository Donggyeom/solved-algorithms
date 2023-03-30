import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] S = br.readLine().toCharArray();
		
		int result = 0;
		int OICounter = 0;			// 연속된 OI의 개수 카운트. Pn을 의미.
		int i = 0;
		
		while (i < M) {
			OICounter = 0;
			
			// 첫번째 I를 찾는다.
			if (S[i++] == 'O') continue;
			
			// 연속된 OI개수를 카운트한다.
			while (true) {
				if (i == M) break;
				// O 찾기.
				if (S[i] == 'I') break;	// OI 카운트 반복문 탈출. (인덱스 증가하지 않음)
				// I가 아니므로 O임을 보장. idx 증가.
				i++;
				
				// I 찾기. 
				if (i == M) break;
				if (S[i] == 'O') break;	// OI 카운트 반복문 탈출.
				// O가 아니므로 I였음을 보장. counter 증가. idx 증가.
				OICounter++; i++;
				
			}
			
			// P_oicounter에 포함된 P_n의 개수 = OICounter - (N + 1).  0보다 작을 경우 0으로 변환.
			result += Math.max(OICounter - N + 1, 0);
		}
		
		System.out.println(result);
	}
	
}

/**
 *	5525. IOIOI
 */