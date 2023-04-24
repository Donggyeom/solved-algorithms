import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	static int N, M, B;
	static int[] heights = new int[257];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		B = Integer.parseInt(input[2]);
		int max = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				max = Math.max(max, num);
				min = Math.min(min, num);
				heights[num]++;
			}
		}
		int time = 0;
		while (min < max) {
			if (heights[min] <= B && heights[min] <= heights[max]*2) {
				int num = heights[min];
				B -= num;
				heights[min+1] += num;
				time += num;
				min+=1;
			}
			else {
				int num = heights[max];
				heights[max-1]+= num;
				B += num;
				time += (num*2);
				max-=1;
			}
		}
		System.out.println(time + " " + min);
	}
}

/**
 *  18111. 마인크래프트
 *  
 */