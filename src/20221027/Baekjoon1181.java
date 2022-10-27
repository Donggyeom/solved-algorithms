import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<Integer, Set<String>> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			Set<String> set = map.get(s.length());
			if (set == null) {
				set = new HashSet<String>();
				map.put(s.length(), set);
			}
			set.add(s);
		}
		Integer[] keyArr = map.keySet().stream().toArray(Integer[]::new);
		Arrays.sort(keyArr);

		for (int i : keyArr) {
			Set<String> set = map.get(i);
			String[] strArr = set.stream().toArray(String[]::new);
			Arrays.sort(strArr);
			for (String s : strArr) {
				System.out.println(s);
			}
		}
	}
}

/**
  * 1181. 단어 정렬
  * 
**/