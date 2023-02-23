import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int r = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);
		
		int size = (int) Math.pow(2, N);
		int count = 0;
		int x = 0;
		int y = 0;
		while (size > 1) {
			size /= 2;
			
			if (r < x + size &&
					c >= y + size) {
				count += size*size;
				y += size;
			}
			else if (r >= x + size &&
					c < y + size) {
				count += size*size*2;
				x += size;
			}
			else if (r >= x + size &&
					c >= y + size) {
				count += size*size*3;
				x += size;
				y += size;
			}
		}
		System.out.println(count);
	}
}


/**
  * 1074. Z
  * 
**/