import java.io.*;
class Main_2023_신기한소수_김동겸 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int maxNum = (int) (Math.pow(10, N) - 1);	// 999...9, 길이가 N
//		for ()
		
		// N 자리 까지의 소수를 모두 구한다.
		
		// 1~9 까지 소수를 구한다.
		
		// 앞에서 구한 소수에 10을 곱하고 0~9를 더하고 소수이면 다시 넣는다.
		
		// N 자리 까지 소수를 모두 구한다.
		
	}
}


/**
  * 2023. 신기한 소수
  * 
  * N자리 신기한 소수를 모두 찾아보자.
  * 
  * 입력
  * 
  * 첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.
  * 
  * 출력
  * 
  * N자리 수 중에서 신기한 소수를 오름차순으로 정렬해서 한 줄에 하나씩 출력한다.
**/