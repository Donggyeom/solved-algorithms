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

		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i = i + 2) {
			int idx = str.charAt(i) - 'a';
			idx += Math.pow((str.charAt(i+1)-'0'), 2);
			idx %= 26;
			sb.append(Character.toString('a' + idx));
		}
		System.out.println(sb.toString());
	}
}

/**
  * 구름 6주차 2. 제곱암호
  * 
**/