import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            // 테스트케이스 시작
            // 입력데이터 초기화
            int N = Integer.parseInt(br.readLine());
        	String[] input = br.readLine().split(" ");
        	int[] weight = new int[N];
        	for (int i = 0; i < N; i++) {
        		weight[i] = Integer.parseInt(input[i]);
        	}
        	
        	Permutation p = new Permutation(weight);
        	p.recurse(0);
            
            StringBuilder sb = new StringBuilder();
            sb.append("#");
            sb.append(tc+1);
            sb.append(" ");
            sb.append(p.count);
            sb.append("\n");
        	
        	bw.write(sb.toString());
            // 테스트케이스 끝
        }
        bw.flush();
    }
}

class Permutation {
	int[] arr;
	int[] temp;
	int l;
	boolean[] bUsed;
	
	int count;
	
	public Permutation(int[] arr) {
		this.arr = arr;
		this.temp = new int[arr.length];
		this.l = arr.length;
		this.bUsed = new boolean[arr.length];
		
		this.count = 0;
	}
	
	public void recurse(int r) {
		if (r == l) {
			verify(0, 0, 0);
			return;
		}
		
		for (int i = 0; i < l; i++) {
			if (bUsed[i]) continue;
			
			bUsed[i] = true;
			temp[r] = arr[i];
			recurse(r+1);
			
			bUsed[i] = false;
		}
	}
	
	private void verify(int r, int left, int right) {
		if (left < right) return;
		
		if (r == l) {
			this.count++;
			return;
		}
		
		verify(r+1, left, right + temp[r]);
		verify(r+1, left + temp[r], right);
	}
}