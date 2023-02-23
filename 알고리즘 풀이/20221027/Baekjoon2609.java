import java.io.*;
import java.util.ArrayList;
import java.util.List;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		
		List<Integer> gcf = new ArrayList<>();	// 최대공약수
		List<Integer> lcm = new ArrayList<>();	// 최소공배수
		
		gcf.add(1);
		lcm.add(1);
		
		int i = 2;
		while (A != 1 || B != 1) {
			if (A % i == 0 && B % i == 0) {
				gcf.add(i);
				lcm.add(i);
				
				A /= i;
				B /= i;
			}
			else if (A % i == 0 || B % i == 0) {
				lcm.add(i);
				if (A % i ==0) {
					A /= i;
				}
				else {
					B /= i;
				}
			}
			else {
				i++;
			}
		}
		gcf.stream().reduce((x, y) -> x*y).ifPresent(intVal -> System.out.println(intVal));
		lcm.stream().reduce((x, y) -> x*y).ifPresent(intVal -> System.out.println(intVal));
	}
}

/**
  * 2609. 최대공약수와 최소공배수
  * 
**/