import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		
		TreeSet<Integer> vacancySet = new TreeSet<>();
		for (int i = 0; i <= P; i++) {
			vacancySet.add(i);
		}
		int docked = 0;
		for (docked = 0; docked < P; docked++) {
			int num = Integer.parseInt(br.readLine());
			int target = vacancySet.floor(num);
			
			if (target < 1) break;
			else vacancySet.remove(target);
		}
		System.out.println(docked);
	}
}

/**
 *  10775. 공항
 *  
 */