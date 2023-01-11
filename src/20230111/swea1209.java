import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int tc = 0; tc < 10; tc++) {
			// 테스트케이스 시작
			br.readLine();	// 테스트케이스 번호
			int[] rowSum = new int[100];
			int[] colSum = new int[100];
			int[] crossSum = new int[2];	// 0: \  1: /
			int[][] array = new int[100][100];
			for (int i = 0; i < 100; i++) {
				String[] input = br.readLine().split(" ");
				array[i] = new int[100];
				for (int j = 0; j < 100; j++) {
					array[i][j] = Integer.parseInt(input[j]);
					rowSum[i] += array[i][j];
					colSum[j] += array[i][j];
				}
			}
			for (int i = 0; i < 100; i++) {
				crossSum[0] += array[i][i];
				crossSum[1] += array[i][99-i];
			}
			
			int max = Integer.MIN_VALUE;
			max = Math.max(max, Arrays.stream(rowSum).max().getAsInt());
			max = Math.max(max, Arrays.stream(colSum).max().getAsInt());
			max = Math.max(max, Arrays.stream(crossSum).max().getAsInt());
			
			bw.write("#" + Integer.toString(tc+1) + " " + max + "\n");
			// 테스트케이스 끝
		}
		bw.flush();
	}

}
