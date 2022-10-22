import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String[] strToken = str.split(" ");
		
		int answer = strToken.length;
		if (str.charAt(0) == ' ') answer--;
		if (answer == -1) answer = 0;
		
		System.out.println(answer);
	}
}


/**
  * 1152. 단어의 개수
  * 
**/