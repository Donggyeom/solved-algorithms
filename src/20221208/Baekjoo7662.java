import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
	
	static int MAX = 100000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			TreeSet<Integer> treeSet = new TreeSet<>();
			Map<Integer, Integer> map = new HashMap<>();
			int K = Integer.parseInt(br.readLine());
			for (int i = 0; i < K; i++) {
				String[] input = br.readLine().split(" ");
				
				if ("I".equals(input[0])) {
					int num = Integer.parseInt(input[1]);
					Integer count = map.get(num);
					if (count == null) {
						map.put(num, 1);
						treeSet.add(num);
					}
					else {
						map.put(num, count.intValue()+1);
					}
				}
				// "D".equals(input[0])
				else {
					String direction = input[1];
					
					if (treeSet.isEmpty()) continue;
					
					int target;
					if (direction.equals("1")) {
						// 최댓값 삭제
						target = treeSet.last();
					}
					// direction.equals("-1")
					else {
						// 최솟값 삭제
						target = treeSet.first();
					}
					
					int count = map.get(target);
					if (count == 1) {
						map.remove(target);
						treeSet.remove(target);
					}
					else {
						map.put(target, count-1);
					}
				}
			}
			// 출력
			if (treeSet.isEmpty()) {
				sb.append("EMPTY\n");
			}
			else {
				sb.append(treeSet.last());
				sb.append(" ");
				sb.append(treeSet.first());
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}

/**
  * 7662. 이중 우선순위 큐
  * 
**/