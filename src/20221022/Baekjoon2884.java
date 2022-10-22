import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int H = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int remaining = 45;
		
		if (M < 45) {
			H -= 1;
			M += 60;
		}
		M -= remaining;
		
		if (H < 0) H += 24;
		
		System.out.println(H + " " + M);
	}
}


/**
  * 2884. 알람 시계
  * 
**/