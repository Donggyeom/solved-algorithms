import java.io.*;
import java.util.*;
import java.util.stream.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] timetable = new int[N][2];
		
		String[] input = null;
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			timetable[i][0] = Integer.parseInt(input[0]);
			timetable[i][1] = Integer.parseInt(input[1]);
		}
		
		// 시간순으로 정렬
		Arrays.sort(timetable, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) {
					return o1[0] - o2[0];
				}
				else
					return o1[1] - o2[1];
			}
			
		});
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		priorityQueue.offer(1);
		
		for (int i = 0; i < N; i++) {
			int s = priorityQueue.peek();
			
			if (s <= timetable[i][0]) {
				priorityQueue.poll();
				priorityQueue.offer(timetable[i][1]);
			}
			else {
				priorityQueue.offer(timetable[i][1]);
			}
			
		}
		System.out.println(priorityQueue.size());
	}
}

/**
  * 11000. 강의실 배정
  * 
**/