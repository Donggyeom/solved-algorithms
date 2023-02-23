import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution_1228_D3_암호문1_김동겸 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(100);
		LinkedList<Integer> list = new LinkedList<>();
		
		for (int tc = 1; tc <= 10; tc++) {
			// 테스트케이스 실행
			list.clear();
			
			int N = Integer.parseInt(br.readLine());
			String[] cryptogram  = br.readLine().split(" ");
			int M = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 10; i++) {	// N >= 10
				list.add(Integer.parseInt(cryptogram[i]));
			}
			
			for (int i = 0; i < M; i++) {
				st.nextToken();	// "I"
				int x = Integer.parseInt(st.nextToken());	// 삽입할 위치
				int y = Integer.parseInt(st.nextToken()) ;		// 삽입할 개수
				for (int j = 0; j < y; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (x < 10)
						list.add(x++, num);
				}
			}
			
			// 출력데이터 세팅
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
}


/**
  * 1228. 암호문1
  * 
	[입력]
	
	첫 번째 줄 : 원본 암호문의 길이 N ( 10 ≤ N ≤ 20 의 정수)
	
	두 번째 줄 : 원본 암호문
	
	세 번째 줄 : 명령어의 개수 ( 5 ≤ N ≤ 10 의 정수)
	
	네 번째 줄 : 명령어
	
	위와 같은 네 줄이 한 개의 테스트 케이스이며, 총 10개의 테스트 케이스가 주어진다.
	
	[출력]
	
	#기호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 수정된 암호문의 처음 10개 항을 출력한다.
**/