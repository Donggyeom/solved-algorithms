import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
class Main2 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		int[] result = new int[N];
		int resultIdx = 0;
		
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		int idx = K-1;
		int[] temp = new int[N];
		while (true) {
			int count = 0;
			for (idx = idx % N; idx < N; idx += K) {
				temp[count++] = idx; 
			}
			
			for (int i = count-1; i >= 0; i--) {
				result[resultIdx + i] = list.remove(temp[i]);
			}
			resultIdx += count;
			idx -= N;
			N = list.size();

			if (N < 1) break;
			
			idx %= N;
			
		}
		
		StringBuilder sb = new StringBuilder(N);
		sb.append("<");
		for (int c : result) {
			sb.append(c).append(", ");
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());
	}
}


/**
  * 백준 1158. 요세푸스 문제
  * 

**/