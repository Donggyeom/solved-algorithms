import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(10);
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int min = Integer.MAX_VALUE;
			String[] mbti = br.readLine().split(" ");
			if (N > 32) min = 0;
			else {
				for (int i = 0; i < N - 2; i++) {
					char[] cmp1 = mbti[i].toCharArray();
					for (int j = i+1; j < N - 1; j++) {
						char[] cmp2 = mbti[j].toCharArray();
						for (int k = j+1; k < N; k++) {
							char[] cmp3 = mbti[k].toCharArray();
							int cmpCount = 0;
							for (int l = 0; l < 4; l++) {
								if (cmp1[l] != cmp2[l]) cmpCount++;
								if (cmp2[l] != cmp3[l]) cmpCount++;
								if (cmp1[l] != cmp3[l]) cmpCount++;
							}
							min = Math.min(min, cmpCount);
						}
					}
				}
			}
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
}

/**
 *  20529. 가장 가까운 세 사람의 심리적 거리
 *  
 */