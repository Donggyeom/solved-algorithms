import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int N, M;
		N = Integer.parseInt(input[0]);	// 나무의 수(1 <= N <= 10^6)
		M = Integer.parseInt(input[1]);	// 나무의 길이(1 <= M <= 2*10^9)
		
		int[] tree = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int max = 0;
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}
		int answer = 0;
		int min = 0;
		BINARY_SEARCH:
			while (true) {
//				System.out.printf("min : %d ", min);
//				System.out.printf("max : %d\n", max);
				if (min > max) break;
				int mid = (min + max) / 2;
				long sum = 0;
				for (int i = 0; i < N; i++) {
					sum += Math.max(0, tree[i] - mid);
					if (sum >= M) {
						answer = mid;
						min = mid + 1;
						continue BINARY_SEARCH;
					}
				}
				max = mid-1;
				
				if (min > max) break;
			}
		
		System.out.println(answer);
	}
}

/**
 *  2805. 나무 자르기
 *  
 */