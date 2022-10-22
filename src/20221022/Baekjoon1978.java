import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		ArrayList<Integer> numbers = new ArrayList<>();
		for (String sInput : input) {
			numbers.add(Integer.parseInt(sInput));
		}
		numbers.sort(Comparator.naturalOrder());
		
		int cnt = numbers.size();
		int maxNum = numbers.get(cnt-1);
		
		boolean[] bCompositeNumber = new boolean[maxNum+1];
		bCompositeNumber[0] = bCompositeNumber[1] = true;
		int sqrtNum = (int) Math.sqrt(maxNum) + 1;
		for (int i = 2; i <= maxNum; i++) {
			if (i > sqrtNum) break;		// i�� sqrtNum���� ũ�� �տ��� �ɷ��� �ռ����� �����ϰ� maxNum���� ��� �Ҽ�
			
			if (bCompositeNumber[i] == false) {
				for (int j = i + i; j <= maxNum; j = j + i) {
					// i�� ����� ��� �ռ���
					bCompositeNumber[j] = true;
				}
			}
		}
		
		int answer = 0;
		for (Integer i : numbers) {
			if (bCompositeNumber[i] == false)
				answer++;
		}
		System.out.println(answer);
		
		// System.out.println();
	}
}


/**
  * 1978. �Ҽ� ã��
  * 
  *   �־��� �� N�� �߿��� �Ҽ��� �� ������ ã�Ƽ� ���
  *  
  * �Է�
  *   ���� ���� N, N�� 100 ����
  *   N���� 1000 ������ ��
  *   
  * ���
  *   �Ҽ��� ����
  *   
  * '�����佺�׳׽��� ü' �˰���
  * 
**/