import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			edges.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]) - 1;
			int b = Integer.parseInt(input[1]) - 1;
			
			edges.get(a).add(b);
			edges.get(b).add(a);
		}
		
		int answer = 0;
		boolean[] bVisited = new boolean[N];
		for (int i = 0; i < N; i++) {
			if ( !bVisited[i] ) {
				Stack<Integer> dfs = new Stack<>();
				dfs.push(i);
				answer++;
				while ( !dfs.isEmpty() ) {
					int p = dfs.pop();
					if (bVisited[p]) continue;
					// System.out.println(p);
					bVisited[p] = true;
					for (Integer np : edges.get(p)) {
						if ( !bVisited[np] ) {
							dfs.push(np);
						}
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}

/**
 * 11724. 연결 요소의 개수
 * 
 */