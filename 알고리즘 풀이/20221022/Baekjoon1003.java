import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// String input = br.readLine();
		int T = Integer.parseInt(br.readLine());		
		
		int num[] = new int[T];
		int maxNum = 0;
		for (int i = 0; i < T; i++) {
			num[i] = Integer.parseInt(br.readLine());
			maxNum = maxNum < num[i] ? num[i] : maxNum;
		}
		
		int fibo[] = new int[41];
		fibo[0] = fibo[1] = 1;
		for (int i = 2; i <= maxNum; i++) {
			fibo[i] = fibo[i-2] + fibo[i-1];
		}
		
		for (int i = 0; i < num.length; i++) {
			if (num[i]-2 >= 0) {
				System.out.println(fibo[num[i]-2] + " " + fibo[num[i]-1]);
			}
			else if (num[i] == 1) {
				System.out.println("0 1");
			}
			else if (num[i] == 0) {
				System.out.println("1 0");
			}
			
		}
		
		// System.out.println();
	}
}


/**
  * 1003. 피보나치 함수
  * 
  * 0  1 0
  * 1  0 1
  * 2  1 1  fibo[0] fibo[1]
  * 3  1 2  fibo[1] fibo[2]
  * 4  2 3  fibo[2] fibo[3]
  * 
  * fibo
  * idx :  0 1 2 3 4 5
  * val :  1 1 2 3 5 8
  * 
**/