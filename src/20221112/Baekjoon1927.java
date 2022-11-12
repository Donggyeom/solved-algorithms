import java.io.*;
import java.util.*;
class Main {
	
	static int[] dx = { -1,  0,  1,  0};
	static int[] dy = {  0,  1,  0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if ("0".equals(s)) {
				if (que.isEmpty()) {
					bw.write("0");
				}
				else {
					bw.write(Integer.toString(que.poll()));
				}
				bw.write("\n");
			}
			else {
				que.add(Integer.parseInt(s));
			}
		}
		
		bw.flush();
	}
}


/**
  * 1927. 최소 힙
  * 
**/