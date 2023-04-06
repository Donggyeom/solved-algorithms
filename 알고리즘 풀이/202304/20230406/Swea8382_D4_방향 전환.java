import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(10);
		for (int tc = 1; tc <= TC; tc++) {
			String[] input = br.readLine().split(" ");
			int x1 = Integer.parseInt(input[0]);
			int y1 = Integer.parseInt(input[1]);
			int x2 = Integer.parseInt(input[2]);
			int y2 = Integer.parseInt(input[3]);
			int dx = Math.abs(x1 - x2);
			int dy = Math.abs(y1 - y2);
			int min = Math.min(dx, dy);
			int dd = Math.abs(dx-dy);
			
			sb.append("#").append(tc).append(" ").append(min*2+4*(dd/2) + dd%2).append("\n");
		}
		System.out.println(sb);
	}
}

/**
 *  swea 8382. 방향 전환
 */
