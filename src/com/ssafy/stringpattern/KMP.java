package com.ssafy.stringpattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class KMP {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] text = in.readLine().trim().toCharArray();
		char[] pattern = in.readLine().trim().toCharArray();
		
		int tlen = text.length;
		int plen = pattern.length;
		
		// fail함수
		int[] fail = new int[plen];
		
		/*
		 * i : 접미사 포인터 ( i = 1부터 시작 )
		 * j : 접두사 포인터 
		 */
		for (int i = 1, j=0; i < plen; i++) {
			while(j > 0 && pattern[i] != pattern[j]) {
				j = fail[j-1];
			}
			if (pattern[i] == pattern[j]) fail[i] = ++j;
		}
		
		// 본문 비교
		Deque<Integer> list = new ArrayDeque<>();
		for (int i = 0, j = 0; i < fail.length; i++) {
			// 원문과 패턴이 맞지 않으면 j위치를 이동
			while (j > 0 && text[i] != pattern[j]) j = fail[j-1];
			
			// 두 글자가 일치하면
			if (text[i] == pattern[j]) {
				// j가 패턴의 끝이므로 본문과 패턴이 일치
				if (j == plen-1) {
					list.add((i+1) - plen+1); // 패턴이 일치한 시작 위치
					j = fail[j];
				}
				else {
					j++;
				}
			}
		}
		
		int cnt = list.size();
		System.out.println(cnt);
		StringBuilder sb = new StringBuilder(cnt*3);
		if (cnt>0) {
			
		}
		
	}

}
