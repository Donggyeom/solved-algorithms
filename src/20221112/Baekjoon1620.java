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
		int M = Integer.parseInt(input[1]);
		
		Map<String, Integer> map = new HashMap<>();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map.put(str, i+1);
			arr[i] = str;
		}
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (str.matches("\\d*")) {
				bw.write(arr[Integer.parseInt(str)-1]+"\n");
			}
			else {
				bw.write(map.get(str).intValue()+"\n");
			}
		}
		
		
		bw.flush();
	}
}


/**
  * 1620. 나는야 포켓몬 마스터 이다솜
  * 
**/