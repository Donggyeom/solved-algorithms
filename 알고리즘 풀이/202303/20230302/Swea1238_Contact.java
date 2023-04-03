import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static class Node {
		int num;
		ArrayList<Integer> link;
		
		public Node(int num) {
			this.num = num;
			link = new ArrayList<>();
		}
	}
	
	static int T, L, S;	// T : 테스트케이스 개수. L : 데이터 개수. S : 시작점
	static Node[] nodeList = new Node[101];
	static boolean[] visited = new boolean[101];
	static int result;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(10);
		
		T = 10;
		
		int tc = 1;
		while (tc <= T) {
			// 테스트케이스 시작
			String[] input = br.readLine().split(" ");
			L = Integer.parseInt(input[0]) / 2;
			S = Integer.parseInt(input[1]);
			Arrays.fill(visited, false);
			// 노드 초기화
			for (int i = 1; i <= 100; i++) {
				nodeList[i] = new Node(i);
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 엣지 추가
			for (int i = 0; i < L; i++) {
				nodeList[Integer.parseInt(st.nextToken())].link.add(Integer.parseInt(st.nextToken()));
			}
			
			bfs();
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
			tc++;
		}
		System.out.println(sb);
	}


	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(S);
		visited[S] = true;
		while ( !queue.isEmpty() ) { 
			int max = 0;
			for (int i = 0, size = queue.size(); i < size; i++) {
				int idx = queue.poll();
				for (int next : nodeList[idx].link) {
					if (visited[next]) continue;
					
					result = 0;
					visited[next] = true;
					max = Math.max(max, next);
					queue.offer(next);
				}
			}
			
			result = Math.max(result, max);
		}
	}

}

/**
 *	swea 1238. Contact 
 */
