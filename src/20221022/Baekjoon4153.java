import java.io.*;
import java.util.Arrays;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = null;
		while ( !(input = br.readLine()).equals("0 0 0") ) {
			int nums[] = new int[3];
			int i = 0;
			for (String s : input.split(" ")) {
				nums[i++] = Integer.parseInt(s);
			}
			Arrays.sort(nums);
			if (nums[0]*nums[0] + nums[1]*nums[1] == nums[2]*nums[2])
				System.out.println("right");
			else
				System.out.println("wrong");
		}
		
		// System.out.println();
	}
}


/**
  * 4153. Á÷°¢»ï°¢Çü
**/