import java.io.*;
import java.util.*;
class Main {
	
	static int[] dx = { -1,  0,  1,  0};
	static int[] dy = {  0,  1,  0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		
		ArrayList<Integer> all = new ArrayList<>();
		for (int i = 1; i <= 20; i++) {
			all.add(i);
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			switch(input[0]) {
			case "add":
				set.add(Integer.parseInt(input[1]));
				break;
			case "remove":
				set.remove(Integer.parseInt(input[1]));
				break;
			case "check":
				if (set.contains(Integer.parseInt(input[1]))) {
					bw.write("1\n");
				}
				else {
					bw.write("0\n");
				}
				break;
			case "toggle":
				int t = Integer.parseInt(input[1]);
				if (set.contains(t)) {
					set.remove(t);
				}
				else {
					set.add(t);
				}
				break;
			case "all":
				set.addAll(all);
				break;
			case "empty":
				set.clear();
				break;
			}
		}
		
		bw.flush();
	}
}


/**
  * 11723. 집합
  * 
**/