import java.io.*;
import java.util.HashSet;
import java.util.Set;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Set<Integer> remainder = new HashSet<>();
		
		for (int i = 0; i < 10; i++) {
			remainder.add(Integer.parseInt(br.readLine()) % 42);	
		}
		
		System.out.println(remainder.size());
	}
}


/**
  * 3052. ³ª¸ÓÁö
  * 
**/