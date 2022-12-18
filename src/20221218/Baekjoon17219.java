import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		Map<String, String> passwordMap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			passwordMap.put(input[0], input[1]);
		}
		for (int i = 0; i < M; i++) {
			bw.write(passwordMap.get(br.readLine()));
			bw.write("\n");
		}
		bw.flush();
	}
}

/**
  * 17219. 비밀번호 찾기
  * 
**/