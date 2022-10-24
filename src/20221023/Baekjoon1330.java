import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);		
		int B = Integer.parseInt(input[1]);	

		String s = "";
		if (A > B)	s = ">";
		else if (A == B) s = "==";
		else s = "<";
		
		System.out.println(s);
	}
}


/**
  * 1330. 두 수 비교하기
  * 
**/