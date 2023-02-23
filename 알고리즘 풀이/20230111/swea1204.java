import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			// 테스트케이스 시작
			br.readLine();	// 테스트케이스 번호 = tc
			int[] numberCounterArray = new int[101];
			int numberCount = 0;
			while (numberCount < 1000) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				while (st.hasMoreTokens()) {
					numberCounterArray[Integer.parseInt(st.nextToken())]++;
					numberCount++;
				}
			}
			
			int modeCount = -1;
			int modeIdx = -1;
			for (int i = 0; i < 101; i++) {
				if (modeCount <= numberCounterArray[i]) {
					modeCount = numberCounterArray[i];
					modeIdx = i;
				}
			}
			bw.write("#" + Integer.toString(tc+1) + " " + modeIdx + "\n");
			// 테스트케이스 끝
		}
		bw.flush();
	}

}
