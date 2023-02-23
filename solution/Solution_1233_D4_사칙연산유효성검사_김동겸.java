import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution_1233_D4_사칙연산유효성검사_김동겸 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(10);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			boolean result = true;
			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				if (result && 
						input.length == 2 && !isNumber(input[1].charAt(0)) ||
						input.length == 4 && isNumber(input[1].charAt(0))) 
				{
					// 리프노드인데 숫자가 아닐 경우 또는 리프노드가 아닌데 숫자인 경우
					result = false;
				}
			}
			
			sb.append("#").append(tc).append(" ")
				.append(result? 1 : 0).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}
	
}


/**
  * SWEA - 사칙연산 유효성 검사
  * 
	[입력]

	각 테스트 케이스의 첫 줄에는 각 케이스의 트리가 갖는 정점의 총 수 N(1≤N≤200)이 주어진다.
	
	그 다음 N줄에 걸쳐 각각의 정점 정보가 주어진다.
	
	해당 정점에 대한 정보는 해당 정점의 알파벳, 해당 정점의 왼쪽 자식, 오른쪽 자식의 정점번호가 차례대로 주어진다.
	
	정점 번호는 1부터 N까지의 정수로 구분된다. 입력에서 정점 번호를 매기는 규칙은 위와 같으며, 루트 정점의 번호는 반드시 1이다.
	
	입력에서 이웃한 숫자 또는 연산자, 자식 정점의 번호는 모두 공백으로 구분된다.
	
	위의 예시에서, 숫자 8이 4번 정점에 해당하면 “4 8”으로 주어지고, 연산자 ‘/’가 2번 정점에 해당하면 두 자식이 각각 숫자 ‘8’인 4번 정점과 숫자 ‘2’인 5번 정점이므로 “2 / 4 5”로 주어진다.
	
	총 10개의 테스트 케이스가 주어진다.
	
	[출력]
	
	#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 정답을 출력한다.
**/