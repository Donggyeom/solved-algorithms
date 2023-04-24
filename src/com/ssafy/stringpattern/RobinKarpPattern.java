package com.ssafy.stringpattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class RobinKarpPattern {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			char[] text = in.readLine().trim().toCharArray();
			char[] pattern = in.readLine().trim().toCharArray();
			
			long pHash=0, tHash=0, power=1;
			long base = 26;
			long mod = 1000000009;
			int tlen = text.length;
			int plen = pattern.length;
			Deque<Integer> list = new ArrayDeque<>();
			
			// pattern의 개수만큼 본문의 hash와 pattern의 hash를 구하기
			for (int i = 0; i < plen; i++) {
				pHash = (pHash*base) % mod;
				pHash = (pHash+pattern[i]) % mod;
				tHash = (tHash*base) % mod;
				tHash = (tHash+text[i]) % mod;
				
				if (i < plen - 1) power = (power * base) % mod;
			}
			
			if (pHash==tHash) {
				list.add(1);
			}
			
			for (int i = 1; i <= tlen-plen; i++) {
				//본문의 새로운 hash만들기
				tHash = (((tHash - (text[i-1] * power)%mod + mod)%mod*base)
						+ text[i+plen-1])%mod;
				if (pHash == tHash) {
					list.add(i+1);
				}
			}
			
			System.out.println("size : " + list.size());
			for (int index : list) {
				System.out.print(index + " ");
			}
			System.out.println();
			
		}
	}

}
