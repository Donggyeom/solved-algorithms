import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		
		boolean[] bCompositeNumber = new boolean[N+1];
		bCompositeNumber[0] = bCompositeNumber[1] = true;
		int NSqrt = (int) Math.sqrt(N) + 1; 
		for (int i = 2; i <= N; i++) {
			if (i > NSqrt) break;		// 앞에서 제거한 합성수를 제외한 N의 제곱근보다 큰 수는 모두 소수 
			
			if (bCompositeNumber[i] == false) {
				for (int j = i + i; j <= N; j = j + i) {
					bCompositeNumber[j] = true;
				}
			}			
		}
		
		for (int i = M; i <= N; i++) {
			if (bCompositeNumber[i] == false)
				System.out.println(i);
		}
		
		// System.out.println();
	}
}


/**
  * 1929. 소수 구하기
  * 
  *   M 이상 N 이하 소수를 모두 출력
  *  
  * 입력
  *   M N ( 1 <= M <= N < 1,000,000)
  *   
  * '에라토스테네스의 체' 알고리즘
  * 
**/