import java.io.*;
import java.util.*;
class Main {
	
	static int[] dx = { -1,  0,  1,  0};
	static int[] dy = {  0,  1,  0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		
		Deque<Integer> que = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			switch(input[0]) {
			case "push":
				que.offer(Integer.parseInt(input[1]));
				break;
			case "pop":
				if (!que.isEmpty())
					System.out.println(que.poll());
				else
					System.out.println(-1);
				break;
			case "size":
				System.out.println(que.size());
				break;
			case "empty":
				if (que.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "front":
				if (!que.isEmpty())
					System.out.println(que.peek());
				else
					System.out.println(-1);
				break;
			case "back":
				if (!que.isEmpty())
					System.out.println(que.peekLast());
				else
					System.out.println(-1);
				break;
			}
		}
	}
}


/**
  * 10845. 큐
  * 
**/