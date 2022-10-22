import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		
		boolean[] bCompositeNumber = new boolean[N+1];
		bCompositeNumber[0] = bCompositeNumber[1] = true;
		int NSqrt = (int) Math.sqrt(N) + 1; 
		for (int i = 2; i <= N; i++) {
			if (i > NSqrt) break;		// �տ��� ������ �ռ����� ������ N�� �����ٺ��� ū ���� ��� �Ҽ� 
			
			if (bCompositeNumber[i] == false) {
				for (int j = i + i; j <= N; j = j + i) {
					bCompositeNumber[j] = true;
				}
			}			
		}
		
		for (int i = M; i <= N; i++) {
			if (bCompositeNumber[i] == false)
				System.out.println(i);
		}
		
		// System.out.println();
	}
}


/**
  * 1929. �Ҽ� ���ϱ�
  * 
  *   M �̻� N ���� �Ҽ��� ��� ���
  *  
  * �Է�
  *   M N ( 1 <= M <= N < 1,000,000)
  *   
  * '�����佺�׳׽��� ü' �˰���
  * 
**/