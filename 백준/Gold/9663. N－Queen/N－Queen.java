import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int[] qColumns;
	static int N;
	static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		qColumns = new int[N + 1];
		
		dfs(1);
		
		System.out.println(count);
	}
	
	private static void dfs(int depth) {
		if (depth > N) {
			count++;
			
//			System.out.println(Arrays.toString(qColumns));
			
			return;
		}
		
		IS_VALID:
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j < depth; j++) {
					// depth : 이번 행,  i : 이번 열,  j : 이전 행,  qColumns[j] : 이전 열
					if (qColumns[j] == i || Math.abs(depth - j) == Math.abs(i - qColumns[j])) {
						continue IS_VALID;
					}
				}
				
				qColumns[depth] = i;
				dfs(depth + 1);
				qColumns[depth] = 0;
			}
		
	}
}	

/**
 *  9663. N-Queen
 *  
 */