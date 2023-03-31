import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// NLogN
// C[k] 배열 : 길이 N의 LIS에 대하여 k 길이에 올 수 있는 가장 작은 값 저장
// C 배열의 길이 = LIS
public class LIS_2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] C = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int k = 0;	// LIS size
		C[k++] = arr[0];
		for (int i = 1; i < N; i++) {
			// arr[i] : 탐색키  => 찾으면 찾은 데이터의 index 리턴
			//					못찾으면 마지막까지 찾은 위치*-1 - 1
			//					  => i번째 원소가 C[]에 저장되야 할 위치
			
			int temp = Arrays.binarySearch(C, 0, k, arr[i]);
			temp = Math.abs(temp)-1;
			C[temp] = arr[i];
			if (k == temp) {
				// 맨 끝에 추가된 상황
				k++;
			}
			
		}
		
		System.out.println(k);
	}
}
