import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
	
	static StringBuilder sb = new StringBuilder(10);
	
	static int L, C;
	static char[] arr;
	static int[] consonants;
	static int[] vowels;
	
	static char[] temp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		arr = new char[C];
		consonants = new int[C];
		vowels = new int[C];
		temp = new char[L];
		for (int i = 0; i < C; i++) {
			char c = sc.next().charAt(0);
			arr[i] = c;
		}
		Arrays.sort(arr);
		for (int i = 0; i < C; i++) {
			char c = arr[i];
			if (c == 'a' ||
					c == 'e' ||
					c == 'i' ||
					c == 'o' ||
					c == 'u')
				{
					vowels[i]++;
				}
			else consonants[i]++;
		}
		
		combination(0, 0, 0, 0);
		
		System.out.print(sb);
		
		sc.close();
	}
	
	static void combination(int cnt, int s, int consonant, int vowel) {
		if (cnt == L) {
			if (consonant > 1 && vowel > 0)
				sb.append(String.valueOf(temp)).append("\n");
			return;
		}
		
		for (int i = s; i < C; i++) {
			temp[cnt] = arr[i];
			combination(cnt+1, i+1, consonant+consonants[i], vowel+vowels[i]);
		}
	}
}

/**
 *	1759. 암호 만들기 
 */