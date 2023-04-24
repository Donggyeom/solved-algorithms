package com.ssafy.slidingwindow;

public class MaxSumArray1 {

	public static void main(String[] args) {
		int[] nums = {2,4,7,10,8,4,5,6,7,1};
		int max = 0, sum = 0;
		int k = 4, n = nums.length;
		
		
		// 1. k개의 서브 요소를 원하는 방법으로 처리한다.
		for (int i = 0; i < k; i++) {
			sum += nums[i];
		}
		
		// 2. N-k만큼을 반복 돌면서 윈도우의 시작분을 빼고, 윈도우 맨 끝에 새 요소를 추가한다.
		for (int i = 0, size = n-k; i < size; i++) {
			sum -= nums[i];
			
		}
	}

}
