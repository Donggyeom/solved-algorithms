import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	
	static int N, d, k, c;
	static int[] arr;
	
	static Map<Integer, Integer> map = new HashMap<>();
	static int maxCount = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		d = Integer.parseInt(input[1]);
		k = Integer.parseInt(input[2]);
		c = Integer.parseInt(input[3]);
		arr = new int[N+k-1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (i < k-1) {
				arr[i+N] = arr[i];
			}
		}
		
		for (int i = 0; i < N && i < k-1; i++) {
			add(arr[i]);
			int size = map.size();
			maxCount = Math.max(maxCount, size);
		}
		for (int i = k-1; i < N+k-1; i++) {
			add(arr[i]);
			int size = map.size();
			maxCount = Math.max(maxCount, size + (map.containsKey(c)?0:1));
			remove(arr[i-k+1]);
		}
		
		System.out.println(Math.min(maxCount, d));
	}
	
	static void add(int num) {
		Integer target = map.get(num);
		if (target == null) map.put(num, 1);
		else map.put(num, target+1);
	}
	
	static void remove(int num) {
		Integer target = map.get(num);
		if (target.intValue() == 1) map.remove(num);
		else map.put(num, target-1);
	}
}

/**
 *  15961. 회전초밥
 *  
 */
