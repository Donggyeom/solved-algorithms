import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
	
	static int N, K, T;
	static boolean[] visited;
	static int[] next;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		T = 0;
		visited = new boolean[100001];
		next = new int[3];
		
		// N을 +,- 1 또는 *2 해서 가장 빠르게 같아질 수 있는 스텝수
		bfs();
		
		System.out.println(T);
		sc.close();
	}


	private static void bfs() {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		
		while (!queue.isEmpty()) {
			for (int i = 0, size = queue.size(); i < size; i++) {
				int cur = queue.poll();
				
				if (cur == K) return;
				
				next[0] = cur-1;
				next[1] = cur+1;
				next[2] = cur*2;
				
				for (int j = 0; j < 3; j++) {
					int np = next[j];
					if (isValidPoint(np) && !visited[np]) {
						visited[np] = true;
						queue.offer(np);
					}
				}
					
			}
			T++;
		}
	}
	
	private static boolean isValidPoint(int cur) {
		return cur>=0 && cur <= 100000;
	}
}

/**
 *  1697. 숨바꼭질
 */