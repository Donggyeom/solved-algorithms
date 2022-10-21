import java.io.*;
class Baekjoon2502 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int D = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int a = 0, b = 0;
		
		int[] pivDP = new int[D-1];	// K = piv[D-3]*a + piv[D-2]*b, a=첫번째날 떡의개수 , b=두번째날 떡의개수, D >= 3
		pivDP[0] = pivDP[1] = 1;
		for (int i = 2; i < D-1; i++) {
			pivDP[i] = pivDP[i-2] + pivDP[i-1];
		}
		
		for (int i = (K-1) / pivDP[D-2]; i >= 1; i--) {
			if ( (K - i * pivDP[D-2]) % pivDP[D-3] == 0) {
				b = i;
				a = (K - i * pivDP[D-2]) / pivDP[D-3];
				break;
			}
		}

		System.out.println(a);
		System.out.println(b);
	}
}

/*
6 41

3
a+b	1 1    piv[0]a + piv[1]b
4
a+2b	1 2
5
(a+2b)+(a+b) = 2a+3b
6
(2a+3b)+(a+2b) = 3a+5b
7
(3a+5b)+(2a+3b) = 5a+8b
8
(5a+8b)+(3a+5b) = 8a+13b

*/