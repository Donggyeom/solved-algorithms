import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			// 테스트케이스 시작
			int N = Integer.parseInt(br.readLine());
			// 배열 저장
			String[][] arr = new String[N][N];
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine().split(" ");
			}
			
			bw.write("#");
			bw.write(Integer.toString(tc+1));
			bw.write("\n");
			
			// 회전 배열 출력
			int nMinusOne = N-1;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					// 90도 회전 배열
					bw.write(arr[nMinusOne-j][i]);
				}
				bw.write(" ");
				for (int j = 0; j < arr.length; j++) {
					// 180도 회전 배열
					bw.write(arr[nMinusOne-i][nMinusOne-j]);
				}
				bw.write(" ");
				
				for (int j = 0; j < arr.length; j++) {
					// 270도 회전 배열
					bw.write(arr[j][nMinusOne-i]);
				}
				bw.write("\n");
			}
			
			// 테스트케이스 끝
		}
		bw.flush();
	}

}
