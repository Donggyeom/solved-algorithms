import java.io.*;
import java.util.StringTokenizer;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N =  Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] nums = new int [N];
		int maxNum = 0;
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			maxNum = maxNum > nums[i] ? maxNum : nums[i];
		}
		
		double sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (double) nums[i] / maxNum;
		}
				
		System.out.println(sum / N * 100);
	}
}


/**
  * 1546. ЦђБе
  * 
**/