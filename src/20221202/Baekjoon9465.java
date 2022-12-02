import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][N+1];
			int[][] dpArr = new int[3][N+1];

			for (int i = 0; i < 2; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Integer.parseInt(input[j-1]);
				}
			}
			
			for (int i = 1; i <= N; i++) {
				dpArr[0][i] = Math.max(dpArr[1][i-1], dpArr[2][i-1]) + arr[0][i];
				dpArr[1][i] = Math.max(dpArr[0][i-1], dpArr[2][i-1]) + arr[1][i];
				dpArr[2][i] = Math.max(dpArr[0][i-1], Math.max(dpArr[1][i-1], dpArr[2][i-1]));
			}
			
			System.out.println(Math.max(dpArr[0][N], Math.max(dpArr[1][N], dpArr[2][N])));
		}
		
	}
}

/**
  * 9465. 스티커
  * 
  * 마지막 줄을 사용하지 않는 경우,
  * 위에 스티커를 사용한 경우,
  * 아래 스티커를 사용한 경우로 dp
  * 
**/