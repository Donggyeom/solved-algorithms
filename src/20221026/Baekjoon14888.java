import java.io.*;
import java.util.Stack;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		
		// a 배열 초기화
		int[] aArr = new int[N];
		for (int i = 0; i < N; i++) {
			aArr[i] = Integer.parseInt(input[i]);
		}
		
		// 연산자 개수 초기화
		input = br.readLine().split(" ");
		int[] opArr = new int[4];
		for (int i = 0; i < 4; i++) {
			opArr[i] = Integer.parseInt(input[i]);
		}
		
		MyCalculator.aArr = aArr;
		Stack<MyCalculator> dfs = new Stack<>();
		dfs.push(new MyCalculator(aArr[0], 1, opArr.clone()));
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		while ( !dfs.isEmpty() ) {
			MyCalculator mc = dfs.pop();

			if (mc.aIdx == N) {
				if (mc.sum > max) max = mc.sum;
				if (mc.sum < min) min = mc.sum;
			}
			
			if (mc.opArr[0] > 0) {
				int[] opArrNew = mc.opArr.clone();
				opArrNew[0] -= 1;
				dfs.push(new MyCalculator(mc.sum + mc.aArr[mc.aIdx], mc.aIdx+1, opArrNew));
			}
			
			if (mc.opArr[1] > 0) {
				int[] opArrNew = mc.opArr.clone();
				opArrNew[1] -= 1;
				dfs.push(new MyCalculator(mc.sum - mc.aArr[mc.aIdx], mc.aIdx+1, opArrNew));
			}
			
			if (mc.opArr[2] > 0) {
				int[] opArrNew = mc.opArr.clone();
				opArrNew[2] -= 1;
				dfs.push(new MyCalculator(mc.sum * mc.aArr[mc.aIdx], mc.aIdx+1, opArrNew));
			}
			
			if (mc.opArr[3] > 0) {
				int[] opArrNew = mc.opArr.clone();
				opArrNew[3] -= 1;
				dfs.push(new MyCalculator(mc.sum / mc.aArr[mc.aIdx], mc.aIdx+1, opArrNew));
			}
		}
		
		System.out.println(max);
		System.out.println(min);
	}
}

class MyCalculator {
	static int[] aArr;
	int sum;
	int aIdx;
	int[] opArr;
	
	public MyCalculator(int sum_, int aIdx_, int[] opArr_) {
		sum = sum_;
		aIdx = aIdx_;
		opArr = opArr_;
	}
}


/**
  * 14888. 연산자 끼워넣기
  * 
**/