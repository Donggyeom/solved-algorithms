import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = null;
		
		int[] map = new int[101];
		for (int i = 1; i <= 100; i++) {
			map[i] = i;
		}
		
		int N, M;
		input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		for (int i = 0, total = N+M; i < total; i++) {
			int s, e;
			input = br.readLine().split(" ");
			s = Integer.parseInt(input[0]);
			e = Integer.parseInt(input[1]);
			
			map[s] = e;
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[101];
		int step = 0;
		queue.offer(1);
		visited[1] = true;
		while (!queue.isEmpty()) {
			BFS:
				for (int i = 0, size = queue.size(); i < size; i++) {
					int curIdx = queue.poll();
					for (int dice = 1; dice < 7; dice++) {
						int nextIdx = curIdx + dice;
						if (visited[nextIdx]) continue;
						
						visited[nextIdx] = true;
						nextIdx = map[nextIdx];
						visited[nextIdx] = true;
						
						if (nextIdx == 100) {
							queue.clear();
							break BFS;
						}
						
						queue.offer(nextIdx);
					}
				}
			
			step++;
		}
		
		System.out.println(step);
	}
}

/**
 *  16928. 뱀과 사다리 게임
 *  
 */