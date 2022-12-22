import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] members = new String[N];
		for (int i = 0; i < N; i++) {
			members[i] = br.readLine();
		}
		Arrays.stream(members).sorted((m1, m2) -> {
			return Integer.parseInt(m1.split(" ")[0]) - Integer.parseInt(m2.split(" ")[0]);
		}).forEach(s -> {
			try {
				bw.append(s);
				bw.append("\n");
			} catch (IOException e) {
				System.out.println("bw append error");
			}
		});
		
		bw.flush();
	}
}

/**
  * 10814. 나이순 정렬
  * 
**/