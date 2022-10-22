import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			int sum = 0;
			int cnt = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'X') {
					cnt = 0;
				}
				else {
					cnt++;
					sum += cnt;
				}
			}
			
			System.out.println(sum);
		}
	}
}


/**
  * 8958. OXÄûÁî
  * 
**/