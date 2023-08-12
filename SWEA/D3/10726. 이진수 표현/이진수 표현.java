import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static int T;
	
	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder(10);
		String[] inputs = null;
		for (int tc = 1; tc <= T; tc++) {
			inputs = br.readLine().split(" "); 
			N = Integer.parseInt(inputs[0]);
			M = Integer.parseInt(inputs[1]);
			int targetNumber = (1 << N) - 1;
			
			sb.append("#").append(tc).append(" ")
				.append((targetNumber & M) == targetNumber ? "ON" : "OFF").append("\n");
		}
		System.out.print(sb);
	}
	
}
