import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine().toUpperCase();
		
		int[] alphaCnt = new int[26];
		
		for (int i = 0; i < str.length(); i++) {
			alphaCnt[str.charAt(i)-'A']++;
		}
		
		int maxIdx = -1;
		int maxNum = 0;
		for (int i = 0; i < 26; i++) {
			if (maxNum < alphaCnt[i]) {
				maxNum = alphaCnt[i];
				maxIdx = i;
			}
			else if (maxNum == alphaCnt[i]){
				maxIdx = 100;
			}
		}
		
		if (maxIdx == 100) {
			System.out.println("?");
		}
		else {
			System.out.println(Character.toString('A' + maxIdx));
		}
		
		
	}
}


/**
  * 1157. 단어 공부
  * 
**/