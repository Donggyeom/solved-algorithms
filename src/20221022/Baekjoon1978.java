import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		ArrayList<Integer> numbers = new ArrayList<>();
		for (String sInput : input) {
			numbers.add(Integer.parseInt(sInput));
		}
		numbers.sort(Comparator.naturalOrder());
		
		int cnt = numbers.size();
		int maxNum = numbers.get(cnt-1);
		
		boolean[] bCompositeNumber = new boolean[maxNum+1];
		bCompositeNumber[0] = bCompositeNumber[1] = true;
		int sqrtNum = (int) Math.sqrt(maxNum) + 1;
		for (int i = 2; i <= maxNum; i++) {
			if (i > sqrtNum) break;		// i가 sqrtNum보다 크면 앞에서 걸러진 합성수를 제외하고 maxNum까지 모두 소수
			
			if (bCompositeNumber[i] == false) {
				for (int j = i + i; j <= maxNum; j = j + i) {
					// i의 배수는 모두 합성수
					bCompositeNumber[j] = true;
				}
			}
		}
		
		int answer = 0;
		for (Integer i : numbers) {
			if (bCompositeNumber[i] == false)
				answer++;
		}
		System.out.println(answer);
		
		// System.out.println();
	}
}


/**
  * 1978. 소수 찾기
  * 
  *   주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력
  *  
  * 입력
  *   수의 개수 N, N은 100 이하
  *   N개의 1000 이하의 수
  *   
  * 출력
  *   소수의 개수
  *   
  * '에라토스테네스의 체' 알고리즘
  * 
**/