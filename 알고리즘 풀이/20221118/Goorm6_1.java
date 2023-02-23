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
		
		for (int j = 0; j < 5; j++) {
			String N = br.readLine();
		
			int a =  0;
			for (int i = 0; i < 7; i = i + 2) {
				a += N.charAt(i) - '0';
			}
			for (int i = 1; i < 7; i = i + 2) {
				if (N.charAt(i) != '0')
					a *= N.charAt(i) - '0';
			}
			System.out.println(a%10);
		}
		
	}
}

/**
  * 구름 6주차 1. 7게임
  * 
**/