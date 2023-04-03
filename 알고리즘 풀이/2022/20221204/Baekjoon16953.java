import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		
		System.out.println(bfs(A, B));
	}
	
	static int bfs(int A, int B) {
		int answer = 1;
		
		Queue<Long> que = new LinkedList<>();
		que.offer((long)A);
		
		while ( !que.isEmpty() ) {
			int len = que.size();
			for (int i = 0; i < len; i++) {
				long num = que.poll();
				
				if (num == B) {
					return answer;
				}
				
				if (num < B) {
					que.offer(num << 1);
					que.offer(num*10+1);
				}
			}
			answer++;
		}
		
		return -1;
	}
}

/**
  * 16953. A → B
  * 
**/