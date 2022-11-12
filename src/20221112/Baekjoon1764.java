import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
class Main {
	
	static int[] dx = { -1,  0,  1,  0};
	static int[] dy = {  0,  1,  0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		Set<String> setA = new HashSet<>();
		Set<String> setB = new HashSet<>();
		for (int i = 0; i < N; i++) {
			setA.add(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			setB.add(br.readLine());
		}
		setA.retainAll(setB);
		bw.write(Integer.toString(setA.size()));
		bw.write("\n");
		for (String str : setA.stream().sorted().collect(Collectors.toList())) {
			bw.write(str);
			bw.write("\n");
		}
		
		bw.flush();
	}
}


/**
  * 1764. 듣보잡
  * 
**/