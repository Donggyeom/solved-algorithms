import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static boolean[][] bNum = new boolean[10][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		N = Integer.parseInt(br.readLine());
		for (int i = 1; i < 10; i++) {
			bNum[i] = new boolean[N + 1];
		}
		input = br.readLine().split(" ");

		// 각 숫자(1~9)별 위치를 체크
		for (int i = 0; i < N; i++) {
			int S_i = Integer.parseInt(input[i]);
			bNum[S_i][i + 1] = true;
		}

		// 두 숫자의 조합으로 연속최장길이를 구함
		int answer = 0;
		for (int i = 1; i < 10; i++) {
			int max = 0;
			for (int j = i + 1; j < 10; j++) {
				int length = 0;
				for (int k = 1; k <= N; k++) {
					if (bNum[i][k] || bNum[j][k]) {
						length++;
					} else {
						length = 0;
					}

					max = Math.max(max, length);
				}
			}
			answer = Math.max(answer, max);
		}

		System.out.println(answer);
	}

}

/**
 * 30804. 과일 탕후루
 * 
 */