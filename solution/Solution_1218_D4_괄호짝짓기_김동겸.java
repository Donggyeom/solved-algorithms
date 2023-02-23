import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution_1218_D4_괄호짝짓기_김동겸 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<Character, Character> pairMap = new HashMap<>();
		Stack<Character> stk = new Stack<>();
		int[] result = new int[11];	// 0 버림
		
		
		pairMap.put('(', ')');
		pairMap.put('<', '>');
		pairMap.put('[', ']');
		pairMap.put('{', '}');
		
		for (int tc = 1; tc <= 10; tc++) {
			int length = Integer.parseInt(br.readLine());
			char[] bracket = br.readLine().toCharArray();
			result[tc] = 1;
			
			for (int i = 0; i < length; i++) {
				char c = bracket[i];
				if (pairMap.containsKey(c)) {
					stk.push(c);
				}
				else {
					if (pairMap.get(stk.pop()) != bracket[i]) {
						result[tc] = 0;
						break;
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, result[tc]);
		}
	}
	
}


/**
  * 1218. 괄호 짝짓기
  * 
**/