import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);
		int w = Integer.parseInt(input[2]);
		int h = Integer.parseInt(input[3]);
		
		int dx = Math.min(x, w-x);
		int dy = Math.min(y, h-y);
		
		System.out.println(Math.min(dx, dy));
		
		// System.out.println();
	}
}


/**
  * 1085. ���簢������ Ż��
  * 
  *   ���簢���� ��輱���� ���� �Ÿ��� �ּڰ�
  *   ���� �Ʒ� ������ (0, 0)
  *   ������ �� ������ (w, h)
  *   
  *   ���� ��ġ ��ǥ (x, y)
  *  
  * �Է�
  *   x, y, w, h
  *   
  * ���
  *   ���簢���� ��輱���� ���� �Ÿ��� �ּڰ�
  * 
**/