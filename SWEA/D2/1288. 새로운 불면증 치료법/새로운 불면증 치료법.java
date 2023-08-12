import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static int T;
	
	static final int allVisited = 0b1111111111;
	static int N;
	static int visited;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder(10);
		for (int tc = 1; tc <= T; tc++) {
			// init
			N = Integer.parseInt(br.readLine());
			visited = 0;
			answer = 0;
			
			getAnswer(N);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}
	
	static void getAnswer(int number) {
		int i = number;
		while (i > 0) {
			int num = i % 10;
			visited |= (1 << num);
			i /= 10;
		}
		if (visited == allVisited) {
			answer = number;
			return;
		}
		
		getAnswer(number + N);
	}

}
