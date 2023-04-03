import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int K = Integer.parseInt(input[2]);
		
		long[] numbers = new long[N];
		long[] sumDp = new long[N];
		
		numbers[0] = Long.parseLong(br.readLine());
		sumDp[0] = numbers[0];
		
		for (int i = 1; i < N; i++) {
			numbers[i] = Long.parseLong(br.readLine());
			sumDp[i] = sumDp[i-1] + numbers[i]; 
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int MK = M + K;
		for (int i = 0; i < MK; i++) {
			input = br.readLine().split(" ");
			
			if ("1".equals(input[0])) {
				// 1. 수 바꾸기
				int idx = Integer.parseInt(input[1]) - 1;
				long to = Long.parseLong(input[2]);
				long from = numbers[idx];
				long diff = to - from;
				numbers[idx] = to;
				for (int j = idx; j < N; j++) {
					sumDp[j] += (long) diff;					
				}
			}
			else {
				// 2. 합 구하기
				int fromIdx = Integer.parseInt(input[1]) - 1;
				int toIdx = Integer.parseInt(input[2]) - 1;
				
				if (fromIdx >= 1)
					bw.write(sumDp[toIdx] - sumDp[fromIdx-1] + "\n");
				else {
					bw.write(sumDp[toIdx] + "\n");
				}
			}
		}
		bw.flush();
		
		// System.out.println();
	}
}


/**
  * 2042. 구간 합 구하기
  * 
**/