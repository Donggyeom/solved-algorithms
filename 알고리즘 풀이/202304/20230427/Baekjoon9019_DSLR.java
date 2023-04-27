import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	/*
	 	D: D 는 n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다. 그 결과 값(2n mod 10000)을 레지스터에 저장한다.
		S: S 는 n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다. n이 0 이라면 9999 가 대신 레지스터에 저장된다.
		L: L 은 n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d2, d3, d4, d1이 된다.
		R: R 은 n의 각 자릿수를 오른편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d4, d1, d2, d3이 된다.
	 */
	static class History {
		int n;
		String str;
		public History(int n, String sb) {
			super();
			this.n = n;
			str = sb;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder res = new StringBuilder(10);
		for (int tc = 0; tc < T; tc++) {
			String[] input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			
			res.append(bfs(A, B)).append("\n");
		}
		System.out.println(res);
	}
	
	private static String bfs(int A, int B) {
		Queue<History> queue = new ArrayDeque<>();
		Set<Integer> visited = new HashSet<>();
		queue.offer(new History(A, ""));
		visited.add(A);
		while (!queue.isEmpty()) {
			for (int i = 0, size = queue.size(); i < size; i++) {
				History h = queue.poll();
				int n = h.n;
				// D: D 는 n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다. 그 결과 값(2n mod 10000)을 레지스터에 저장한다.
				int reg = (n << 1) % 10000;
				if (reg == B) return h.str+"D";
				if (!visited.contains(reg)) {
					visited.add(reg);
					queue.offer(new History(reg, h.str+"D"));
				}
				
				// S: S 는 n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다. n이 0 이라면 9999 가 대신 레지스터에 저장된다.
//				reg = (~n + 1) % 10000;
				reg = n-1;
				if (reg < 0) reg = 9999;
				if (reg == B) return h.str+"S";
				if (!visited.contains(reg)) {
					visited.add(reg);
					queue.offer(new History(reg, h.str+"S"));
				}
				
				// L: L 은 n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d2, d3, d4, d1이 된다.
				reg = (n%1000 * 10) + (n / 1000);
				if (reg == B) return h.str+"L";
				if (!visited.contains(reg)) {
					visited.add(reg);
					queue.offer(new History(reg, h.str+"L"));
				}
				
				// R: R 은 n의 각 자릿수를 오른편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d4, d1, d2, d3이 된다.
				reg = (n / 10) + (n%10)*1000;
				if (reg == B) return h.str+"R";
				if (!visited.contains(reg)) {
					visited.add(reg);
					queue.offer(new History(reg, h.str+"R"));
				}
			}
			
		}
		
		return "";
	}
}

/**
 *  9019. DSLR
 *  
 */