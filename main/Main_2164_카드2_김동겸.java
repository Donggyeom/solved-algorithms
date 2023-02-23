import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
class Main_2164_카드2_김동겸 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new LinkedList<>();
				
		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}
		
		while (deque.size() > 1) {
			deque.poll();
			deque.addLast(deque.poll());
		}
		System.out.println(deque.poll());
	}
}


/**
  * 백준_2164. 카드2
  * 
	문제
	(위) 1 ... N (아래) 카드에서 다음 동작을 반복해 마지막 한 장의 카드가 무엇인지 구하시오.
	
	1. 제일 위에 있는 카드를 바닥에 버린다. 
	2. 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
	3. 카드가 한 장 남으면 출력하고 종료한다.
	
	입력
	첫째 줄에 정수 N(1 ≤ N ≤ 500,000)이 주어진다.
	
	출력
	첫째 줄에 남게 되는 카드의 번호를 출력한다.
	
	아이디어
	1. 맨 앞에 원소를 삭제하고 맨 뒤로 이동시켜야 하므로 덱을 사용한다.
**/