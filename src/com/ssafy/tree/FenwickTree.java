package com.ssafy.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FenwickTree {
	
	static int N, M, K;
	static long[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);
		long[] nums = new long[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Long.parseLong(br.readLine());
		}
		tree = new long[N+1];
		for (int i = 1; i <= N; i++) {
			update(i, nums[i-1]);
		}
		StringBuilder sb = new StringBuilder(10);
		for (int i = 0, size = M+K; i < size; i++) {
			input = br.readLine().split(" ");
			long a = Long.parseLong(input[0]);
			long b = Long.parseLong(input[1]);
			long c = Long.parseLong(input[2]);
			if (a == 1) {
				int idx = (int)b;
				update(idx, c - nums[idx-1]);
				nums[idx-1] = c;
			}
			else
				sb.append(sum((int)c) - sum((int)(b-1))).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void update(int i, long num ) {
		while (i <= N) {
			tree[i] += num;
			i += (i & -i);
		}
	}
	
	static long sum(int i) {
		long ans = 0;
		while (i > 0) {
			ans += tree[i];
			i -= (i & -i);
		}
		return ans;
	}
}
