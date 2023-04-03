import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int D = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		int[] pivDP = new int[K-1];	// K = piv[K-3]*a + piv[K-2]*b, a=첫번째날 떡의개수 


		System.out.println();
	}
}

/*
6 / 41


1	2	3	4	5	6
					41

1	1	1	1	1	5+4
				3+4	3+4+4

5 1
4 2
3 3
2 4
1 5
0 1 2 3 4 5 6 7 8
1 1 2 3 5 8

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