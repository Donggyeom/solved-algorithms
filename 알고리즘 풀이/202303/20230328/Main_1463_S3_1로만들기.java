import java.io.BufferedReader;
import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(n);
		int cnt = 0;
		BFS:
			while (!queue.isEmpty()) {
				for (int i = 0, size = queue.size(); i < size; i++) {
					int v = queue.poll();
					if (v == 1) break BFS;
					
					queue.offer(v-1);
					if (v % 2 == 0)
						queue.offer(v/2);
					if (v % 3 == 0)
						queue.offer(v/3);
				}
				
				cnt++;
			}
		
		System.out.println(cnt);
	}

}

/**
 *	1463. 1로 만들기
 */