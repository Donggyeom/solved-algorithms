import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
		int multiply = 1;
		while (N > 0) {
			multiply *= N;
			while (multiply % 10 == 0) {
				multiply /= 10;
				answer++;
			}
			multiply %= 1000;
			N--;
		}
		System.out.println(answer);
	}
}

/**
  * 1676. 팩토리얼 0의 개수
  * 
**/