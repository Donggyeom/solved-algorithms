import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
	
	static int MAX = 100000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		// bfs
		PriorityQueue<Point> que = new PriorityQueue<>();
		boolean[] visited = new boolean[MAX+1];
		que.offer(new Point(N, 0));
		
		int answer = 0;
		BFS:
		while ( !que.isEmpty() ) {
			int length = que.size();

			for (int i = 0 ; i < length; i++) {
				Point item = que.poll();
				int point = item.idx;
				int count = item.count;
				
				if (point == K) {
					answer = count;
					break BFS;
				}
				
				visited[point] = true;
			
				if (point * 2 <= MAX && !visited[point * 2]) {
					que.offer(new Point(point*2, count));
				}
				
				if (point + 1 <= MAX && !visited[point+1]) {
					que.offer(new Point(point+1, count+1));
				}
				
				if (point - 1 >= 0 && !visited[point-1]) {
					que.offer(new Point(point-1, count+1));
				}
				
			}
		}
		
		System.out.println(answer);
	}
}

class Point implements Comparable<Point> {
	int idx;
	int count;
	
	public Point(int idx, int count) {
		this.idx = idx;
		this.count = count;
	}

	@Override
	public int compareTo(Point o) {
		return this.count - o.count;
	}
}

/**
  * 13549. 숨바꼭질 3
  * 
**/