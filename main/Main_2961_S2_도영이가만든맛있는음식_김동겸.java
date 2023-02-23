import java.io.*;
class Main_2961_S2_도영이가만든맛있는음식_김동겸 {
	
	private static int N, result;
	private static int[] acidity;
	private static int[] acerbity;
	private static boolean[] isSelected;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		result = Integer.MAX_VALUE;
		acidity = new int[N];
		acerbity = new int[N];
		isSelected = new boolean[N+1];	// 0 사용 안함
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			acidity[i] = Integer.parseInt(input[0]);
			acerbity[i] = Integer.parseInt(input[1]);
		}
		
		generateSubset(0, 1, 0);
		
		System.out.println(result);
	}
	
	private static void generateSubset(int count, int mulAcidity, int sumAcerbity) {
	    if (count == N) {
	        if (mulAcidity == 1 && sumAcerbity == 0) return;
	        
	        result = Math.min(Math.abs(mulAcidity - sumAcerbity), result);
	        return;
	    }

	    isSelected[count] = true;
	    generateSubset(count+1, mulAcidity*acidity[count], sumAcerbity+acerbity[count]);
	    isSelected[count] = false;
	    generateSubset(count+1, mulAcidity, sumAcerbity);

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