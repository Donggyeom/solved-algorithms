import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		StringBuilder[] reverseSb = new StringBuilder[2];
		
		for (int i = 0; i < 2; i++) {
			reverseSb[i] = new StringBuilder();
			for (int j = input[i].length()-1; j >= 0; j--) {
				reverseSb[i].append(input[i].charAt(j));
			}
		}
		int A = Integer.parseInt(reverseSb[0].toString());
		int B = Integer.parseInt(reverseSb[1].toString());
		
		System.out.println(Math.max(A, B));
	}
}


/**
  * 2908. 상수
  * 
**/