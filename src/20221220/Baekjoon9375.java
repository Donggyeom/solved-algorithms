import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> clothesMap = new HashMap<>();
			for (int i = 0; i < n; i++) {
				String[] input = br.readLine().split(" ");
				Integer itemCount = clothesMap.get(input[1]);
				if (itemCount == null) {
					itemCount = 0;
				}
				itemCount++;
				clothesMap.put(input[1], itemCount);
			}
			
			int total = clothesMap.keySet().stream()
					.map(key -> clothesMap.get(key))
					.reduce(1, (a, b) -> a * (b+1)) - 1;
			
			bw.append(Integer.toString(total));
			bw.append("\n");
		}
		bw.flush();
	}
}



/**
  * 9375. 패션왕 신해빈
  * 
**/