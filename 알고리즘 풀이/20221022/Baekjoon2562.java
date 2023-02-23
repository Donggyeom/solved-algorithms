import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int maxIdx = -1;
		int maxNum = 0;
		for (int i = 0; i < 9; i++) {
			int num = Integer.parseInt(br.readLine());
			if (maxNum < num) {
				maxNum = num;
				maxIdx = i+1;
			}
		}
		
		System.out.println(maxNum);
		System.out.println(maxIdx);
	}
}


/**
  * 2562. 최댓값
  * 
**/