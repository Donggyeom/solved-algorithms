import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			int num = Math.abs(a) - Math.abs(b);
			if (num == 0) {
				if (a == b) return 0;
				else if (a < b) return -1;
				else return 1;
			}
			return num;
		});
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (pq.isEmpty()) {
					bw.append("0");
				}
				else {
					bw.append(Integer.toString(pq.poll()));
				}
				bw.append("\n");
			}
			else {
				pq.offer(num);
			}
		}
		bw.flush();
	}
}



/**
  * 11286. 절댓값 힙
  * 
**/