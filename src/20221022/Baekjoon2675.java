import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String[] input = br.readLine().split(" ");
			int R = Integer.parseInt(input[0]);
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < input[1].length(); j++) {
				for (int k = 0; k < R; k++) {
					sb.append(input[1].charAt(j));
				}
			}
			System.out.println(sb.toString());
		}
	}
}


/**
  * 2675. 문자열 반복
  * 
**/