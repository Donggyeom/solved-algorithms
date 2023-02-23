import java.io.*;
import java.util.*;
class Main {
	
	static int[] dx = { -1,  0,  1,  0};
	static int[] dy = {  0,  1,  0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			switch(input[0]) {
			case "push_front":
				deque.offerFirst(Integer.parseInt(input[1]));
				break;
			case "push_back":
				deque.offerLast(Integer.parseInt(input[1]));
				break;
			case "pop_front":
				if (!deque.isEmpty())
					System.out.println(deque.pollFirst());
				else
					System.out.println(-1);
				break;
			case "pop_back":
				if (!deque.isEmpty())
					System.out.println(deque.pollLast());
				else
					System.out.println(-1);
				break;
			case "size":
				System.out.println(deque.size());
				break;
			case "empty":
				if (deque.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "front":
				if (!deque.isEmpty())
					System.out.println(deque.peek());
				else
					System.out.println(-1);
				break;
			case "back":
				if (!deque.isEmpty())
					System.out.println(deque.peekLast());
				else
					System.out.println(-1);
				break;
			}
		}
	}
}


/**
  * 10866. 덱
  * 
**/