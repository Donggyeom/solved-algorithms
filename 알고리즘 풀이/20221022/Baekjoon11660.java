import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[][] table = new int[N+1][N+1];
		int[][] dpTable = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			String[] sInput = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				table[i][j] = Integer.parseInt(sInput[j-1]);
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dpTable[i][j] = dpTable[i-1][j] + dpTable[i][j-1] - dpTable[i-1][j-1] + table[i][j];
			}
		}
		
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(dpTable[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
		
		for (int i = 0; i < M; i++) {
			String[] sInput = br.readLine().split(" ");
			int x1 = Integer.parseInt(sInput[0]);
			int y1 = Integer.parseInt(sInput[1]);
			int x2 = Integer.parseInt(sInput[2]);
			int y2 = Integer.parseInt(sInput[3]);

			int answer = dpTable[x2][y2] - dpTable[x1-1][y2] - dpTable[x2][y1-1] + dpTable[x1-1][y1-1];
			System.out.println(answer);
		}

		// System.out.println();
	}
}


/**
  * 11660. 구간 합 구하기 5
  * 
**/