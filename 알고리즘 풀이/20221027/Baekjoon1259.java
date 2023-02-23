import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = null;
		while ( !(str = br.readLine()).equals("0") ) {
			String answer = "yes";
			for (int i = 0; i < str.length(); i++) {
				if (i <= str.length()/2) {
					if (str.charAt(i) != str.charAt( str.length()-1-i )) {
						answer = "no";
						break;
					}
				}
			}
			System.out.println(answer);
		}
	}
}

/**
  * 1259. 팰린드롬수
  * 
**/