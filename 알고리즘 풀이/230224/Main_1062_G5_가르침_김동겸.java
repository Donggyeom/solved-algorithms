import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	// a : 0, c : 2, i : 8, n : 13, t : 19
	static int[] characterSet = 
		{ /*0, */1, /*2, */3, 4, 5, 6, 7, /*8, */9, 
			10,11, 12, /*13, */14, 15, 16, 17, 18, /*19,*/
			20, 21, 22, 23, 24, 25
		};
	
	static int N, K, result;	// 1 <= N <= 50, 0 <= K <= 26
	static char[][] stringArray;
	static boolean[][] requiredCharacters;
	static boolean[] selectedAlphabets;
	
	private static void init() throws Exception {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		
		stringArray = new char[N][];
		requiredCharacters = new boolean[N][26];
		selectedAlphabets = new boolean[26];
		selectedAlphabets[0]
				= selectedAlphabets[2]
				= selectedAlphabets[8]
				= selectedAlphabets[13]
				= selectedAlphabets[19] = true;
		
		for (int i = 0; i < N; i++) {
			stringArray[i] = br.readLine().replaceAll("[antic]", "").toCharArray();
			for (int j = 0, len = stringArray[i].length; j < len; j++) {
				char c = stringArray[i][j];
				requiredCharacters[i][c-'a'] = true;
			}
		}
		
		br.close();
	}
	
	public static void main(String[] args) throws Exception {
		init();
		
		if (K < 5) {
			System.out.println(0);
			return;
		}
		
		K -= 5;	// 필수 5개 제외	(1 <= K <= 21)
		
		combination(0, 0);
		
		System.out.println(result);
	}

	private static void combination(int cnt, int s) {
		if (cnt == K) {
			int satisfiedCnt = 0;
			for (int i = 0; i < N; i++) {
				int count = 0;
				for (; count < 26; count++) {
					if (requiredCharacters[i][count] == true && selectedAlphabets[count] != true) break;
				}
				if (count == 26) satisfiedCnt++;
			}
			
			result = Math.max(result, satisfiedCnt);
		}
		
		for (int i = s, len = characterSet.length; i < len; i++) {
			selectedAlphabets[characterSet[i]] = true;
			combination(cnt + 1, i + 1);
			selectedAlphabets[characterSet[i]] = false;
		}
	}
	
	
}

/**
 *  1062. 가르침
 */