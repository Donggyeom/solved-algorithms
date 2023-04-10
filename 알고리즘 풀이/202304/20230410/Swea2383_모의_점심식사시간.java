import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
	
	static int N, map[][], minTime;
	
	static List<int[]> personList;
	static int[][] stair;
	static int[] stairLength;
	static int[][] arrivalTime;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		personList = new ArrayList<>();
		stair = new int[2][2];
		stairLength = new int[2];
		arrivalTime = new int[10][2];
		int[] fStairArrivedCount = new int[155];
		int[] sStairArrivedCount = new int[155];
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(10);
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			personList.clear();
			minTime = Integer.MAX_VALUE;
			int destIdx = 0;
			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					int number = Integer.parseInt(input[j]);
					if (number == 0) continue;
					else if (number == 1) personList.add(new int[] {i, j});
					else {
						stair[destIdx][0] = i;
						stair[destIdx][1] = j;
						stairLength[destIdx] = number;
						destIdx++;
					}
				}
			}
			int personCnt = personList.size();
			
			// 도착 시간 계산
			for (int i = 0; i < personCnt; i++) {
				int[] pCoord = personList.get(i);
				for (int j = 0; j < 2; j++) {
					arrivalTime[i][j] =  Math.abs(pCoord[0] - stair[j][0]) + Math.abs(pCoord[1] - stair[j][1]);
				}
			}
			// 계단에 대한 사람 큐 생성
			for (int i = 0, end = (1<<personCnt); i < end; i++) {
				PriorityQueue<Integer> firstStairQueue = new PriorityQueue<>();
				PriorityQueue<Integer> secondStairQueue = new PriorityQueue<>();
				for (int j = 0, size = personList.size(); j < size; j++) {
					// j는 사람의 번호(0~N-1)
					if ((i & (1<<j)) > 0) {
						// 자리수 비트가 1이면 첫번째 계단
						firstStairQueue.offer(arrivalTime[j][0]);
					}
					else {
						// 자리수 비트가 0이면 두번째 계단
						secondStairQueue.offer(arrivalTime[j][1]);
					}
				}
				// 사람이 모두 도착할 때까지 시뮬
				int fStairCnt = 0, sStairCnt = 0;
				int fStairIdx = -1, sStairIdx = -1;
				// 계단 별 가장 빠른 도착 시간 설정
				fStairIdx = poll(fStairIdx, firstStairQueue);
				sStairIdx = poll(sStairIdx, secondStairQueue);
				Arrays.fill(fStairArrivedCount, 0);	// 시간에 따른 도착 인원수 배열
				Arrays.fill(sStairArrivedCount, 0); // 시간에 따른 도착 인원수 배열
				int arrivedCnt = 0, time = 0;
				while (arrivedCnt < personCnt) {
					++time;
					
					// 계단 상태 갱신
					fStairCnt -= fStairArrivedCount[time];	// 도착한 인원 수 만큼 계단 인원 수에서 뺌
					sStairCnt -= sStairArrivedCount[time];
					arrivedCnt += fStairArrivedCount[time];
					arrivedCnt += sStairArrivedCount[time];
					
					while (fStairIdx != -1 && fStairCnt < 3 && fStairIdx < time) {
						// 큐에 사람이 있고, 계단에 인원이 3명 미만이고, 도착 시간이 현재 시간보다 작거나 같을 때 계단에 인원 추가
						fStairCnt++;
						fStairIdx = -1;
						fStairArrivedCount[time+stairLength[0]]++;	// 도착시간에 도착 인원 수 증가
						fStairIdx = poll(fStairIdx, firstStairQueue);		// 다음 도착 시간 설정
					}
					while (sStairIdx != -1 && sStairCnt < 3 && sStairIdx < time) {
						// 큐에 사람이 있고, 계단에 인원이 3명 미만이고, 도착 시간이 현재 시간보다 작거나 같을 때 계단에 인원 추가
						sStairCnt++;
						sStairIdx = -1;
						sStairArrivedCount[time+stairLength[1]]++;	// 도착시간에 도착 인원 수 증가
						sStairIdx = poll(sStairIdx, secondStairQueue);		// 다음 도착 시간 설정
					}
					
				}
				
				minTime = Math.min(minTime, time);
			}
			
			sb.append("#").append(tc).append(" ").append(minTime).append("\n");
		}
		System.out.println(sb);
	}

	private static int poll(int idx, PriorityQueue<Integer> pq) {
		if (idx != -1) return idx;
		if (pq.isEmpty()) return -1;
		return pq.poll();
	}
}

/**
 *  swea. 점심 식사시간
 */
