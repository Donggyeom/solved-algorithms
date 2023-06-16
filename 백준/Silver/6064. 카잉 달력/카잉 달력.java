import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(10);
		for (int tc = 1; tc <= T; tc++) {
			int M, N, x, y;
			String[] input = br.readLine().split(" ");
			M = Integer.parseInt(input[0]);
			N = Integer.parseInt(input[1]);
			x = Integer.parseInt(input[2]);
			y = Integer.parseInt(input[3]);
			
			boolean[] visited = new boolean[M+1];
			int x_ = (y % M) + ((y % M) == 0? M : 0), year = y;
			visited[x_] = true;
			while (x != x_) {
//				System.out.printf("%d %d\n", x_, year);
				x_ = ((x_ + N) % M);
				x_ = x_==0 ? M : x_;
				if (visited[x_]) break;
				visited[x_] = true;
				year += N;
			}
			
			if (x != x_) year = -1;
//			System.out.println("==============");
			
			sb.append(year).append("\n");
		}
		System.out.print(sb);
	}
}

/**
 *  6064. 카잉 달력
 *  
 */