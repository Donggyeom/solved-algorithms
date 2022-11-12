import java.io.*;
import java.util.*;
class Main {
	
	static int[] dx = { -1,  0,  1,  0};
	static int[] dy = {  0,  1,  0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		
		Stack<Integer> stk = new Stack<>();
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			switch(input[0]) {
			case "push":
				stk.push(Integer.parseInt(input[1]));
				break;
			case "pop":
				if (!stk.isEmpty())
					System.out.println(stk.pop());
				else
					System.out.println(-1);
				break;
			case "size":
				System.out.println(stk.size());
				break;
			case "empty":
				if (stk.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "top":
				if (!stk.isEmpty())
					System.out.println(stk.peek());
				else
					System.out.println(-1);
				break;
			}
		}
	}
}


/**
  * 10828. 스택
  * 
**/