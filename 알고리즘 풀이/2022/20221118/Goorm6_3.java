import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			String[] input = br.readLine().split(" ");
			
			while (str.length() > input[1].length()) {
				input[1] = input[1] + input[1];
			}
			String key = input[1].substring(0, str.length());
			StringBuilder sb = new StringBuilder();	
			
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				
				int code = key.charAt(j) % 26;
				int aA = 0;
				if (c >= 'a' && c <= 'z') {
					aA = 'a';
				}
				else if (c >= 'A' && c <= 'Z') {
					aA = 'A';
				}
				else {
					code = -1;
				}
				if (code != -1) {
					c -= aA;
					if (input[0].equals("D"))
						c += (26 - code);
					else
						c += code;
					if (c < 0) c += 26;
					c %= 26;
					c += aA;
				}
				
				sb.append(Character.toChars(c));
			}
			System.out.println(sb.toString());
		}
	}
}

/**
  * 구름 6주차 3. 비밀편지
  * 
**/