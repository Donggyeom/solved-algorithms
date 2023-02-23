import java.io.*;
class Main_12891_S2_DNA비밀번호_김동겸 {
	
	private static int sLength, pLength, result;
	
	private static char[] S;
	
	private static int[] minCount;
	private static int[] cnt;		// 부분문자열의 각 문자 개수를 저장
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		sLength = Integer.parseInt(input[0]);
		pLength = Integer.parseInt(input[1]);
		S = br.readLine().toCharArray();
		minCount = new int[4];
		cnt = new int[4];
		input = br.readLine().split(" ");
		
//		A = 1000001  => 00 => 0
//		T = 1010100  => 10 => 2
//		C = 1000011  => 01 => 1
//		G = 1000111  => 11 => 3
		// 위와 맞게 개수 입력
		minCount[0] = Integer.parseInt(input[0]);
		minCount[1] = Integer.parseInt(input[1]);
		minCount[2] = Integer.parseInt(input[3]);
		minCount[3] = Integer.parseInt(input[2]);
		
		// 처음 cnt 초기화를 위한 첫번째 부분문자열 계산
		for (int i = 0; i < pLength; i++) 
		    cnt[getCharIdx(S[i])]++;
		if (isValid()) result++;

		for (int i = 0, end = sLength - pLength; i < end; i++) {
		    cnt[getCharIdx(S[i])]--;
		    cnt[getCharIdx(S[i + pLength])]++;
		    if (isValid()) result++;
		}
		System.out.println(result);
	}
	
	private static int getCharIdx(char c) {
		return Integer.valueOf(c) >> 1 & 0b11;
		/*
			각 문자의 뒤에서 2~3번째 비트를 cnt의 인덱스로 사용
			A = 1000001  => 00 => 0
			T = 1010100  => 10 => 2
			C = 1000011  => 01 => 1
			G = 1000111  => 11 => 3
		*/
	}
	
	private static boolean isValid() {
		for (int i = 0; i < 4; i++) {
			if (minCount[i] > cnt[i]) return false;
		}
		return true;
	}
}


/**
  * 2961. 도영이가 만든 맛있는 음식
  * 
  * 입력
  * 
  * 첫째 줄에 재료의 개수 N(1 ≤ N ≤ 10)이 주어진다. 다음 N개 줄에는 그 재료의 신맛과 쓴맛이 공백으로 구분되어 주어진다.
  * 모든 재료를 사용해서 요리를 만들었을 때, 그 요리의 신맛과 쓴맛은 모두 1,000,000,000보다 작은 양의 정수이다.
  * 
  * 출력
  * 
  * 첫째 줄에 신맛과 쓴맛의 차이가 가장 작은 요리의 차이를 출력한다. 
**/