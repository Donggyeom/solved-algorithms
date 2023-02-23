import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("src/res/input.txt"));
		
		StringBuilder sb = new StringBuilder(10);
		
		LinkedList<Integer> password = new LinkedList<>();

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				password.add(Integer.parseInt(input[i]));
			}
			int M = Integer.parseInt(br.readLine());
			input = br.readLine().split(" ");
			int cmdIdx = 0;
			for (int i = 0; i < M; i++) {
				switch(input[cmdIdx++]) {
				case "I":	//
					break;
					
				}
			}
		}
		
		br.close();
	}

}

/**
 * 	SWEA 1230. 암호문3
 * 
	0 ~ 999999 사이의 수를 나열하여 만든 암호문이 있다.
	3개의 기능
	1. 삽입 : I x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. s는 덧붙일 숫자들이다.[ ex) I 3 2 123152 487651 ]

	2. 삭제 : D x, y : 앞에서부터 x의 위치 바로 다음부터 y개의 숫자를 삭제한다.[ ex) D 4 4 ]
	
	3. 추가 : A y, s : 암호문의 맨 뒤에 y개의 숫자를 덧붙인다. s는 덧붙일 숫자들이다. [ ex) A 2 421257 796813 ]
	
	명령어 실행 후 수정된 결과의 처음 10개 숫자를 출력
	
	[입력]

	for tc in 1 to 10:
		N : 원본 암호문의 길이  ( 2000 ≤ N ≤ 4000 의 정수)
		
		for i in 1 to N:
			password.add() : 원본 암호문 (LinkedList<Integer>)
		
		M : 명령어의 개수 ( 250 ≤ M ≤ 500 의 정수)
	
		input[] : 명령어 집합. 전부 저장하여 배열로 리턴하기엔 사이즈가 크므로 StringTokenizer를 사용하자. (split으로 했을 때 메모리 사용이 얼마나 되는지 확인)
	
	위와 같은 네 줄이 한 개의 테스트 케이스이며, 총 10개의 테스트 케이스가 주어진다.
	
	[출력]
	
	#기호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 수정된 암호문의 처음 10개 항을 출력한다.
	
	[제약 사항]
	
	실행 시간 60ms 이하
	
	[아이디어]
	
	 - split보다 StringTokenizer 사용
	 
	 - 중간 삽입, 삭제가 많으므로 링크드리스트 사용
	 
	 
		
	
 */