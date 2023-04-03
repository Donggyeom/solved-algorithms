import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String[] input = br.readLine().split(" ");
			int H = Integer.parseInt(input[0]);
			int W = Integer.parseInt(input[1]);
			int N = Integer.parseInt(input[2]);
			StringBuilder answer = new StringBuilder();
			
			int col = (int) Math.ceil((double)N/H); 
			String XX = col < 10? "0"+Integer.toString(col) : Integer.toString(col);
			N = N - ( (int) Math.floor((double)N/H) - (N%H==0? 1 : 0))*H;
			answer.append(Integer.toString(N));
			answer.append(XX);
			
			System.out.println(answer.toString());
		}
	}
}

/**
  * 10250. ACM 호텔
  * 
**/